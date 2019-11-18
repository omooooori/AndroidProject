package com.example.test_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionAndContext extends AppCompatActivity {

    private ListView lvMenu;
    private List<Map<String, Object>> menuList;
    private static final String FROM[] = {"name", "price"};
    private static final int TO[] = {R.id.tvMenuName, R.id.tvMenuPrice};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_and_context);

        lvMenu = findViewById(R.id.lvMenu);
        menuList = createBookList();

        SimpleAdapter adapter = new SimpleAdapter(OptionAndContext.this, menuList, R.layout.row, FROM, TO);
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    private List<Map<String, Object>> createBookList() {
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "How Google Works");
        menu.put("price", "900 ");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "Head First. Design Pattern");
        menu.put("price", "4,600 ");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "Introduction to Machine Learning with Python");
        menu.put("price", "3,400 ");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "Team Geek Google");
        menu.put("price", "2,200 ");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "Introduction to C++ from Ryo Ezoe");
        menu.put("price", "900 ");
        menuList.add(menu);

        return menuList;
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);

            String menuName  = (String)item.get("name");
            String menuPrice = (String)item.get("price");

            Intent intent = new Intent(OptionAndContext.this, MenuThanksActivity.class);
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice);
            startActivity(intent);
        }
    }
}
