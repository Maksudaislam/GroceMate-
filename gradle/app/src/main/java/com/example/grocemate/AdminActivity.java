package com.example.grocemate;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button customerDetailsButton = findViewById(R.id.customer_details_button);
        Button employeeDetailsButton = findViewById(R.id.employee_details_button);
        Button productDetailsButton = findViewById(R.id.product_details_button);

        customerDetailsButton.setOnClickListener(v -> startActivity(new Intent(AdminActivity.this, CustomerDetailsActivity.class)));
        employeeDetailsButton.setOnClickListener(v -> startActivity(new Intent(AdminActivity.this, EmployeeActivity.class)));
        productDetailsButton.setOnClickListener(v -> startActivity(new Intent(AdminActivity.this,   ItemDetailsActivity.class)));
    }
}