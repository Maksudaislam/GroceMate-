package com.example.grocemate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomerActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnLocation = findViewById(R.id.btnLocation);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnSignup = findViewById(R.id.btnSignup);

        btnLocation.setOnClickListener(v -> {
            Toast.makeText(this, "Location Button Clicked", Toast.LENGTH_SHORT).show();
            Intent locationIntent = new Intent(this, LocationActivity.class);
            startActivity(locationIntent);
        });

        btnLogin.setOnClickListener(v -> {
            Toast.makeText(this, "Login Button Clicked", Toast.LENGTH_SHORT).show();
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        });

        btnSignup.setOnClickListener(v -> {
            Toast.makeText(this, "Signup Button Clicked", Toast.LENGTH_SHORT).show();
            Intent signupIntent = new Intent(this, SignupActivity.class);
            startActivity(signupIntent);
        });
    }
}
