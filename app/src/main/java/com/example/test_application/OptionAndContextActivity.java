package com.example.test_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionAndContextActivity extends AppCompatActivity {

    private ListView lvMenu;
    private List<Map<String, Object>> menuList;
    private static final String FROM_BOOK[]       = {"name", "price"};
    private static final int    TO_BOOK[]         = {R.id.tvMenuName, R.id.tvMenuPrice};

//    private static final String FROM_LANGUAGE[] = {"language", "priority", "purpose"};
//    private static final int TO_LANGUAGE[]      = {R.id.tvLanguageName, R.id.tvLanguagePriority, R.id.tvLanguagePriority};
    private static final String FROM_LANGUAGE[]   = {"language", "purpose"};
    private static final int    TO_LANGUAGE[]     = {R.id.tvLanguageName, R.id.tvLanguagePurpose};

    boolean isItemBook = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_and_context);

        lvMenu = findViewById(R.id.lvMenu);
        menuList = createBookList();
        SimpleAdapter adapter = new SimpleAdapter(OptionAndContextActivity.this, menuList, R.layout.row, FROM_BOOK, TO_BOOK);
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new ListMenuAndPriceItemClickListener());

        // For Context menu
        registerForContextMenu(lvMenu);
    }

    private List<Map<String, Object>> createBookList() {
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "How Google Works");
        menu.put("price", "900 ");
        menu.put("publisher", "Nikkei newspaper");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "Head First. Design Pattern");
        menu.put("price", "4,600 ");
        menu.put("publisher", "O REILLY");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "Introduction to Machine Learning with Python");
        menu.put("price", "3,400 ");
        menu.put("publisher", "O REILLY");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "Team Geek Google");
        menu.put("price", "2,200 ");
        menu.put("publisher", "O REILLY");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "Introduction to C++ from Ryo Ezoe");
        menu.put("price", "900 ");
        menu.put("publisher", "KADOKAWA");
        menuList.add(menu);

        return menuList;
    }

    private List<Map<String, Object>> createLanguageList() {
        List<Map<String, Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("language", "C++");
        menu.put("priority", "1");
        menu.put("purpose", "Work, CreateGame, AtCoder, Mother Language");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("language", "Python");
        menu.put("priority", "2");
        menu.put("purpose", "Machine Learning, ROS, Raspberry Pi, AtCoder");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("language", "Go");
        menu.put("priority", "3");
        menu.put("purpose", "System Trade, Web Application, AtCoder, Future");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("language", "Java");
        menu.put("priority", "4");
        menu.put("purpose", "Native Android Develop");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("language", "Kotlin");
        menu.put("priority", "5");
        menu.put("purpose", "Switch Java to Kotlin in the future");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("language", "Haskel");
        menu.put("priority", "6");
        menu.put("purpose", "Functional Language study");
        menuList.add(menu);

        return menuList;
    }

    private class ListMenuAndPriceItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
            order(item);
        }
    }

    private void order(Map<String, Object> menu) {
        String menuName  = (String)menu.get("name");
        String menuPrice = (String)menu.get("price");

        Intent intent = new Intent(OptionAndContextActivity.this, MenuThanksActivity.class);
        intent.putExtra("menuName", menuName);
        intent.putExtra("menuPrice", menuPrice);
        startActivity(intent);
    }

    private class ListProgrammingLanguageItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);

            String languageName     = (String)item.get("language");
//            String languagePriority = (String)item.get("priority");
            String languagePurpose  = (String)item.get("purpose");

            String show = "Language: " + languageName + " Purpose: " + languagePurpose;
            Toast toast = Toast.makeText(OptionAndContextActivity.this, show, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.change_item:
                if(isItemBook) {
                    menuList = createLanguageList();
                    isItemBook = false;
                    SimpleAdapter adapter = new SimpleAdapter(OptionAndContextActivity.this,
                            menuList,
                            R.layout.row_language,
                            FROM_LANGUAGE,
                            TO_LANGUAGE);
                    lvMenu.setAdapter(adapter);
                    lvMenu.setOnItemClickListener(new ListProgrammingLanguageItemClickListener());
                } else {
                    menuList = createBookList();
                    isItemBook = true;
                    SimpleAdapter adapter = new SimpleAdapter(OptionAndContextActivity.this,
                            menuList,
                            R.layout.row,
                            FROM_BOOK,
                            TO_BOOK);
                    lvMenu.setAdapter(adapter);
                    lvMenu.setOnItemClickListener(new ListMenuAndPriceItemClickListener());
                }
                return true;
            case R.id.new_item:
                Toast toast_new_item = Toast.makeText(OptionAndContextActivity.this,
                        "new item option menu item was selected.",
                        Toast.LENGTH_SHORT);
                toast_new_item.show();
                return true;
            case R.id.help:
                Toast toast_help = Toast.makeText(OptionAndContextActivity.this,
                        "help option menu item was selected.",
                        Toast.LENGTH_SHORT);
                toast_help.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_list, menu);
        menu.setHeaderTitle(R.string.context_menu_list_header);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition = info.position;
        Map<String, Object> menu = menuList.get(listPosition);

        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.contextMenuListPublisher:
                String publisher = (String) menu.get("publisher");
                Toast.makeText(OptionAndContextActivity.this, publisher, Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextMenuListOrder:
                order(menu);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
