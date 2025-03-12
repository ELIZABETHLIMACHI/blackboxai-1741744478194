package com.example.cpra3_elc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {
    private EditText editBrand;
    private EditText editModel;
    private Spinner spinnerProcessor;
    private Spinner spinnerRam;
    private Spinner spinnerStorage;
    private Button btnAdd;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editBrand = (EditText) findViewById(R.id.editBrand);
        editModel = (EditText) findViewById(R.id.editModel);
        spinnerProcessor = (Spinner) findViewById(R.id.spinnerProcessor);
        spinnerRam = (Spinner) findViewById(R.id.spinnerRam);
        spinnerStorage = (Spinner) findViewById(R.id.spinnerStorage);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnExit = (Button) findViewById(R.id.btnExit);

        // Set up spinners
        setupSpinners();

        // Add button click listener
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    Computer computer = createComputer();
                    Intent intent = new Intent(MainActivity.this, ListComputersActivity.class);
                    intent.putExtra("computer", computer);
                    startActivity(intent);
                }
            }
        });

        // Exit button click listener
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupSpinners() {
        // Processor options
        ArrayAdapter<CharSequence> processorAdapter = ArrayAdapter.createFromResource(this,
                R.array.processor_options, android.R.layout.simple_spinner_item);
        processorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProcessor.setAdapter(processorAdapter);

        // RAM options
        ArrayAdapter<CharSequence> ramAdapter = ArrayAdapter.createFromResource(this,
                R.array.ram_options, android.R.layout.simple_spinner_item);
        ramAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRam.setAdapter(ramAdapter);

        // Storage options
        ArrayAdapter<CharSequence> storageAdapter = ArrayAdapter.createFromResource(this,
                R.array.storage_options, android.R.layout.simple_spinner_item);
        storageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStorage.setAdapter(storageAdapter);
    }

    private boolean validateFields() {
        if (editBrand.getText().toString().trim().isEmpty()) {
            showToast("Por favor ingrese la marca");
            return false;
        }
        if (editModel.getText().toString().trim().isEmpty()) {
            showToast("Por favor ingrese el modelo");
            return false;
        }
        return true;
    }

    private Computer createComputer() {
        String brand = editBrand.getText().toString().trim();
        String model = editModel.getText().toString().trim();
        String processor = spinnerProcessor.getSelectedItem().toString();
        String ram = spinnerRam.getSelectedItem().toString();
        String storage = spinnerStorage.getSelectedItem().toString();
        
        // For now, we'll use a default image ID. Later we can add image selection functionality
        int defaultImageId = R.drawable.default_computer;
        
        return new Computer(brand, model, processor, ram, storage, defaultImageId);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
