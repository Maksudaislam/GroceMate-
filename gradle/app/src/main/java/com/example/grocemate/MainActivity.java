package com.example.grocemate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button employeeButton = findViewById(R.id.button2);
        Button customerButton = findViewById(R.id.button3);
        Button adminButton = findViewById(R.id.button1);

        employeeButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, EmployeeDetailsActivity.class)));
        customerButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CustomerActivity.class)));
        adminButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AdminActivity.class)));
    }
}
