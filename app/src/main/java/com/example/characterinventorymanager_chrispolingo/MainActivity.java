package com.example.characterinventorymanager_chrispolingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etItemName;
    EditText etItemDescription;
    RecyclerView rvItems;
    Button btnAddItem;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etItemName = findViewById(R.id.etItemName);
        etItemDescription = findViewById(R.id.etItemDescription);
        rvItems = findViewById(R.id.rvItems);
        itemAdapter = new ItemAdapter(getApplication());
        rvItems.setAdapter(itemAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        btnAddItem = findViewById(R.id.btnAddItem);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}