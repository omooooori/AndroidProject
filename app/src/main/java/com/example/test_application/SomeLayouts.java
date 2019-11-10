package com.example.test_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class SomeLayouts extends AppCompatActivity {

    private ProgressBar progressBar;
    private int val = 0;

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
                progressBar.setProgress(val);
                progressBar.setSecondaryProgress(50);
            }
        });
    }

}
