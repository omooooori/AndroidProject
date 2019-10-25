package com.example.test_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvScreen = findViewById(R.id.lvScreen);
        lvScreen.setOnItemClickListener(new ListItemClickListener());
    }

    /**
     * Member class
     * Process when user tap the list.
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = (String)parent.getItemAtPosition(position);
            String show = "You choose the screen : " + item;
            Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
        }
    }
}
