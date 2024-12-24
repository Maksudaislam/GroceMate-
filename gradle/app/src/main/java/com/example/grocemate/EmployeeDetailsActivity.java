package com.example.grocemate;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> employees = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            employees.add(new Item("Employee " + i, R.drawable.employee1 + (i - 1)));
        }

        ItemAdapter adapter = new ItemAdapter(employees);
        recyclerView.setAdapter(adapter);
    }
}
