package com.example.mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClc1(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void onBtnClc2(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void onBtnClc3(View view){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

}