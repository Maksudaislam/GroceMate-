package com.example.grocemate;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {
    private final List<Item> itemList = new ArrayList<>();
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        // RecyclerView setup
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList.add(new Item("Example Item", R.drawable.example_image)); // Example item
        itemAdapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(itemAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.add) {
                    showAddItemDialog();
                    return true;
                }
                else if (item.getItemId() == R.id.delete){
                    showDeleteItemDialog();
                    return true;}

                else return false;
            }

        });
    }

    private void showAddItemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(EmployeeActivity.this);
        builder.setTitle("Add Item");

        final EditText input = new EditText(EmployeeActivity.this);
        input.setHint("Enter item name");
        builder.setView(input);

        builder.setPositiveButton("Add", (dialog, which) -> {
            String newItemName = input.getText().toString().trim();
            if (!newItemName.isEmpty()) {
                itemList.add(new Item(newItemName, R.drawable.default_image));
                itemAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(EmployeeActivity.this, "Item name cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    private void showDeleteItemDialog() {
        if (!itemList.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(EmployeeActivity.this);
            builder.setTitle("Select Item to Delete");

            String[] itemsArray = new String[itemList.size()];
            for (int i = 0; i < itemList.size(); i++) {
                itemsArray[i] = itemList.get(i).getName();
            }

            builder.setItems(itemsArray, (dialog, which) -> {
                itemList.remove(which);
                itemAdapter.notifyDataSetChanged();
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
            builder.show();
        } else {
            Toast.makeText(EmployeeActivity.this, "No items to delete", Toast.LENGTH_SHORT).show();
        }
    }
}
