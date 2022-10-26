package com.example.additioncalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //addtion function

    public void Add(View v){
        EditText et1 = (EditText) findViewById(R.id.editTextNumber);
        EditText et2 = (EditText) findViewById(R.id.editTextNumber3);
        EditText et3 = (EditText) findViewById(R.id.editTextNumber4);

        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());

        int result = num1+num2;

        et3.setText("Result = " + result);
    }
}