package com.example.mobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    EditText inp1;
    EditText inp2;

    TextView out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        inp1 = findViewById(R.id.inp1);
        inp2 = findViewById(R.id.inp2);
        out = findViewById(R.id.out);
        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("created threads");
        System.out.println("__________________________");
        System.out.println("__________________________");

    }

    public void onBtnClick(View view) throws InterruptedException {
        String input1 = String.valueOf(inp1.getText());
        String input2 = String.valueOf(inp2.getText());

        System.out.println(input1);
        System.out.println(input2);
        Palindrome p1 = new Palindrome(input1);


        Palindrome p2 = new Palindrome(input2);

        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("thread 1 started");
        System.out.println("__________________________");
        System.out.println("__________________________");
        p1.start();

        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("thread 2 started");
        System.out.println("__________________________");
        System.out.println("__________________________");

        p2.start();

        p1.join();
        p2.join();

        System.out.println("__________________________");
        System.out.println("__________________________");
        System.out.println("thread 1 "+ p1.is_palindrome);
        System.out.println("thread 2 "+ p2.is_palindrome);
        System.out.println("__________________________");
        System.out.println("__________________________");


        out.setText(input1+" is palindrome: " + String.valueOf(p1.is_palindrome)+"\n"+input2+" is palindrome: " + String.valueOf(p2.is_palindrome));


    }

}