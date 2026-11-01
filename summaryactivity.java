package com.example.mobikazi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvDisplayData = findViewById(R.id.tvDisplayData);
        Button btnGoToQuestionnaire = findViewById(R.id.btnGoToQuestionnaire);

        Intent incomingIntent = getIntent();
        String name = incomingIntent.getStringExtra("USER_NAME");
        String phone = incomingIntent.getStringExtra("USER_PHONE");
        String address = incomingIntent.getStringExtra("USER_ADDRESS");

        String formattedOutput = "Name: " + name + "\nPhone: " + phone + "\nAddress: " + address;
        tvDisplayData.setText(formattedOutput);

        btnGoToQuestionnaire.setOnClickListener(v -> {
            Intent questionnaireIntent = new Intent(SummaryActivity.this, QuestionnaireActivity.class);
            startActivity(questionnaireIntent);
        });
    }
}
