package com.example.mobikazi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etAddress = findViewById(R.id.etAddress);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(UserDetailsActivity.this, SummaryActivity.class);
            intent.putExtra("USER_NAME", etName.getText().toString());
            intent.putExtra("USER_PHONE", etPhone.getText().toString());
            intent.putExtra("USER_ADDRESS", etAddress.getText().toString());
            startActivity(intent);
        });
    }
}
