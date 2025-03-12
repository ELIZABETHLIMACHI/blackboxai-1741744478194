package com.example.cpra3_elc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class ListComputersActivity extends Activity {
    private ListView listViewComputers;
    private ArrayList<Computer> computers;
    private ComputerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_computers);

        // Initialize the computers list if it doesn't exist
        if (computers == null) {
            computers = new ArrayList<>();
        }

        // Get the computer from the intent
        Computer newComputer = (Computer) getIntent().getSerializableExtra("computer");
        if (newComputer != null) {
            computers.add(newComputer);
        }

        // Initialize ListView
        listViewComputers = (ListView) findViewById(R.id.listViewComputers);
        adapter = new ComputerAdapter(this, computers);
        listViewComputers.setAdapter(adapter);

        // Set click listener for the ListView items
        listViewComputers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Computer selectedComputer = computers.get(position);
                Intent intent = new Intent(ListComputersActivity.this, ComputerDetailActivity.class);
                intent.putExtra("selected_computer", selectedComputer);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Return to MainActivity without clearing the list
        finish();
    }
}
