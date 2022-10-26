package com.example.problem1;

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

    public void Reverse(View view) {
        EditText n1 = (EditText) findViewById(R.id.editTextNumber);
        EditText n2 = (EditText) findViewById(R.id.editTextNumber2);

        int num = Integer.parseInt(n1.getText().toString());
        int reversed = 0;

        while(num != 0) {

            int digit = num % 10;
            reversed = reversed * 10 + digit;

            num /= 10;
        }
        n2.setText("Reversed = " + reversed);
    }
}