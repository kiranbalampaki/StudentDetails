package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private Spinner spinnerCountry;
        private AutoCompleteTextView autoCompleteTextView;
        private String[] batch = {"21A","21B","21C","22A","22B","22C","23A","23B","23C"};
        private EditText etName;
        private RadioButton rdoMale, rdoFemale, rdoOthers;
        private TextView tvName, tvGender, tvCountry, tvBatch;
        private Button btnSave;
        private String gender;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            spinnerCountry = findViewById(R.id.spinnerCountry);
            autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
            etName = findViewById(R.id.etName);
            autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
            rdoMale = findViewById(R.id.rdoMale);
            rdoFemale = findViewById(R.id.rdoFemale);
            rdoOthers = findViewById(R.id.rdoOthers);
            btnSave = findViewById(R.id.btnSave);

            tvName = findViewById(R.id.tvName);
            tvGender = findViewById(R.id.tvGender);
            tvCountry = findViewById(R.id.tvCountry);
            tvBatch = findViewById(R.id.tvBatch);

            String countries[] = {"Nepal", "India", "China", "Bhutan"};
            ArrayAdapter adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    countries
            );

            spinnerCountry.setAdapter(adapter);

            ArrayAdapter stringArrayAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.select_dialog_item,
                    batch
            );

            autoCompleteTextView.setAdapter(stringArrayAdapter);
            autoCompleteTextView.setThreshold(1);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rdoMale.isChecked()){
                        gender = "Male";
                    }
                    else if (rdoFemale.isChecked()){
                        gender = "Female";
                    }
                    else if (rdoOthers.isChecked()){
                        gender = "Other";
                    }

                    tvName.setText("Name : " + etName.getText());
                    tvGender.setText("Gender : " + gender);
                    tvCountry.setText("Country : " + spinnerCountry.getSelectedItem().toString());
                    tvBatch.setText("Batch : " + autoCompleteTextView.getText().toString());
                }
            });
        }

}