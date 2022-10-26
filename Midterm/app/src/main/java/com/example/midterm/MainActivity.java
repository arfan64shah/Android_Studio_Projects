package com.example.midterm;

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

    public void Reverse(View view){
        EditText n1 = (EditText) findViewById(R.id.editTextNumber);
        EditText n2 = (EditText) findViewById(R.id.editTextNumber2);

        String num = n1.getText().toString();
        long x = Long.parseLong(num);
        char ch;
        String y=String.valueOf(x), nstr="";;
        for (int i=0; i<y.length(); i++)
        {
            ch= y.charAt(i);
            nstr= ch + nstr;
        }
        nstr = nstr.replace("", " ");
        n2.setText(nstr);

    }

    public void Sum(View view) {
        EditText n1 = (EditText) findViewById(R.id.editTextNumber);
        EditText n2 = (EditText) findViewById(R.id.editTextNumber2);

        long num = Long.parseLong(n1.getText().toString());

        long sum = 0;

        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

        n2.setText("Sum = " + sum);
    }

    public void Tax(View view) {

        EditText n1 = (EditText) findViewById(R.id.editTextNumber);
        EditText n2 = (EditText) findViewById(R.id.editTextNumber2);

        double num = Double.parseDouble(n1.getText().toString());

        if (num <= 20000) {
            double tax1 = num*(0/100);
            n2.setText("Tax is " + tax1);
        }else if (num > 20000 && num <= 40000){
            double tax2 = 0 + 20000*0.1;
            n2.setText("Tax is " + tax2);
        }else if (num > 40000 && num <= 60000){
            double tax2 = 0 + 20000*0.1 + 20000*0.2;
            n2.setText("Tax is " + tax2);
        }else {
            double tax3 = 0 + 20000*0.1 + 20000*0.2 + (num - 60000)*0.3;
            n2.setText("Tax is " + tax3);
        }
    }
}