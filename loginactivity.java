package com.example.mobikazi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Simple verification check to log in
            if (username.equals("admin") && password.equals("password123")) {
                Intent intent = new Intent(LoginActivity.this, UserDetailsActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
