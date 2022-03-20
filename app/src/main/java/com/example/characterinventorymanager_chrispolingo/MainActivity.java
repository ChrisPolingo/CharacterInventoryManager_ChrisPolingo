package com.example.characterinventorymanager_chrispolingo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etItemName;
    EditText etItemDescription;
    RecyclerView rvItems;
    Button btnAddItem;
    ItemAdapter itemAdapter;
    MainViewModel mainViewModel;
    //Creating an update view button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.setupItemList();

        etItemName = findViewById(R.id.etItemName);
        etItemDescription = findViewById(R.id.etItemDescription);
        rvItems = findViewById(R.id.rvItems);
        itemAdapter = new ItemAdapter(getApplication(), mainViewModel);
        rvItems.setAdapter(itemAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        btnAddItem = findViewById(R.id.btnAddItem);

        setupLiveDataObserver();

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etItemName.getText().toString();
                String description = etItemDescription.getText().toString();
                mainViewModel.insert(name, description);
                itemAdapter.notifyDataSetChanged();

            }
        });

    }

    /**
     * setupLiveDataObserver()
     * Starts the observer that watches for a change in the database and updates the item adapter.
     */
    private void setupLiveDataObserver () {
        // Create the observer which updates the UI.
        final Observer<List<Item>> statusObserver = new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable final List<Item> newStatus) {
                // Update the UI, in this case, a TextView.
                //textOrder.setText(textOrder.getText().toString() + "\n" + newStatus );
                itemAdapter.notifyDataSetChanged();
                Log.d("insert", "Live data updated " + newStatus.size());
            }
        };
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mainViewModel.getItemList().observe(this, statusObserver);
    }

}
