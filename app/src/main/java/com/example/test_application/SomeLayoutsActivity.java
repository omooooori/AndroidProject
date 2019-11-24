package com.example.test_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class SomeLayoutsActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int val = 0;

    private CheckBox checkBox[] = new CheckBox[2];
    private String str[] = {"未チェックです", "チェックされた", "チェックされていない"};

    private String spinnerItem[] = {"Spinner", "Android", "Apple", "Window"};
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some_layouts);

        progressBar = findViewById(R.id.progressbar);
        progressBar.setMax(100);

        Button button = findViewById(R.id.progressbar_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val += 10;
                if(val == 0)
                    val = 0;
                progressBar.setProgress(val);
                progressBar.setSecondaryProgress(50);
            }
        });

        checkBox[0] = findViewById(R.id.checkbox1);
        checkBox[0].setChecked(false);
        checkBox[0].setText(str[0]);
        checkBox[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = checkBox[0].isChecked();
                if(check) {
                    checkBox[0].setText(str[1]);
                } else {
                    checkBox[0].setText(str[2]);
                }
            }
        });

        checkBox[1] = findViewById(R.id.checkbox2);
        checkBox[1].setChecked(false);
        checkBox[1].setText(str[0]);
        checkBox[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = checkBox[1].isChecked();
                if (check) {
                    checkBox[1].setText(str[1]);
                } else {
                    checkBox[1].setText(str[2]);
                }
            }
        });

        textView = findViewById(R.id.text_spinner);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItem);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner)parent;
                String item = (String)spinner.getSelectedItem();
                textView.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
