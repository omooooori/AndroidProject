package com.example.test_application;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        if(savedInstanceState == null){
            // FragmentManagerのインスタンス生成
            FragmentManager fragmentManager = getSupportFragmentManager();

            // FragmentTransactionのインスタンスを取得
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // インスタンスに対して張り付け方を指定する
            fragmentTransaction.replace(R.id.container, new FragmentMainActivity());

            // 張り付けを実行
            fragmentTransaction.commit();
        }
    }
}
