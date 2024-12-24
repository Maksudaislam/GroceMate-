package com.example.grocemate;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> customers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            customers.add(new Item("Customer " + i, R.drawable.employee1 + (i - 1)));
        }

        ItemAdapter adapter = new ItemAdapter(customers);
        recyclerView.setAdapter(adapter);
    }
}