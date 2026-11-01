package com.example.mobikazi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class QuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        RadioGroup rgGender = findViewById(R.id.rgGender);
        EditText etAge = findViewById(R.id.etAge);
        CheckBox cbEnglish = findViewById(R.id.cbEnglish);
        CheckBox cbKiswahili = findViewById(R.id.cbKiswahili);
        CheckBox cbOther = findViewById(R.id.cbOther);
        EditText etOtherLanguage = findViewById(R.id.etOtherLanguage);
        Button btnSubmitQuestionnaire = findViewById(R.id.btnSubmitQuestionnaire);

        // Control input availability of the alternate language text line field elements
        cbOther.setOnCheckedChangeListener((buttonView, isChecked) -> {
            etOtherLanguage.setEnabled(isChecked);
            if (!isChecked) {
                etOtherLanguage.setText("");
            }
        });

        btnSubmitQuestionnaire.setOnClickListener(v -> {
            // Validate Gender Choice
            int selectedGenderId = rgGender.getCheckedRadioButtonId();
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton rbSelectedGender = findViewById(selectedGenderId);
            String gender = rbSelectedGender.getText().toString();

            // Validate Age Value String Array
            String age = etAge.getText().toString().trim();
            if (age.isEmpty()) {
                etAge.setError("Age is required");
                return;
            }

            // Assemble Selected Checking Profile Options Data Objects
            ArrayList<String> languages = new ArrayList<>();
            if (cbEnglish.isChecked()) languages.add("English");
            if (cbKiswahili.isChecked()) languages.add("Kiswahili");
            if (cbOther.isChecked()) {
                String otherLang = etOtherLanguage.getText().toString().trim();
                if (otherLang.isEmpty()) {
                    etOtherLanguage.setError("Please specify your language");
                    return;
                }
                languages.add("Other (" + otherLang + ")");
            }

            if (languages.isEmpty()) {
                Toast.makeText(this, "Select at least one language", Toast.LENGTH_SHORT).show();
                return;
            }

            // Build formatting overview report dialogue element
            StringBuilder summary = new StringBuilder();
            summary.append("Gender: ").append(gender).append("\n");
            summary.append("Age: ").append(age).append("\n");
            summary.append("Languages: ").append(android.text.TextUtils.join(", ", languages));

            new AlertDialog.Builder(this)
                    .setTitle("MobiKazi Submission Successful!")
                    .setMessage(summary.toString())
                    .setPositiveButton("Close App", (dialog, which) -> finishAffinity())
                    .setNegativeButton("Edit", null)
                    .show();
        });
    }
}
