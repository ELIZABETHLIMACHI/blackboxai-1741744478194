package com.example.cpra3_elc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class cccc extends Activity {
    private ImageView imageComputer;
    private TextView textBrand;
    private TextView textModel;
    private TextView textProcessor;
    private TextView textRam;
    private TextView textStorage;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_detail);

        // Initialize views
        imageComputer = (ImageView) findViewById(R.id.imageComputerDetail);
        textBrand = (TextView) findViewById(R.id.textBrandDetail);
        textModel = (TextView) findViewById(R.id.textModelDetail);
        textProcessor = (TextView) findViewById(R.id.textProcessorDetail);
        textRam = (TextView) findViewById(R.id.textRamDetail);
        textStorage = (TextView) findViewById(R.id.textStorageDetail);
        btnBack = (Button) findViewById(R.id.btnBack);

        // Get computer object from intent
        Computer computer = (Computer) getIntent().getSerializableExtra("selected_computer");

        if (computer != null) {
            // Set the values to the views
            imageComputer.setImageResource(computer.getImageId());
            textBrand.setText(getString(R.string.detail_brand, computer.getBrand()));
            textModel.setText(getString(R.string.detail_model, computer.getModel()));
            textProcessor.setText(getString(R.string.detail_processor, computer.getProcessor()));
            textRam.setText(getString(R.string.detail_ram, computer.getRam()));
            textStorage.setText(getString(R.string.detail_storage, computer.getStorage()));
        }

        // Set back button click listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
