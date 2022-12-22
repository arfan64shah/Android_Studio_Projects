package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    Button button;
    TextView textView;
    String finalResult = "";
    class SynchThread extends Thread {
        Date date = new Date();
        private int step;
        private int max_int;
        private String result = "";
        public SynchThread(int step, int max_int){
            this.step = step;
            this.max_int = max_int;
        }
        public String getResult(){
            return result;
        }

        @Override
        public void run() {
            String text = "Thread "+step+"\n";
            for (int i = step; i<=max_int; i=i+(2*step-1)){
                if (isPrime(i)){
                    text += i+"\n";
                }
            }
            finalResult += text;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        button=(Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number_of_threads =  Integer.parseInt(editText.getText().toString());
                Date old_date = new Date();

                int max_int = Integer.parseInt(editText2.getText().toString());
                SynchThread[] arrayThreads = new SynchThread[number_of_threads];

                finalResult = "";
                for (int i = 0; i<arrayThreads.length; i++){
                    arrayThreads[i] = new SynchThread(i+1,max_int);
                    arrayThreads[i].start();
                }
                try {
                    for (int i = 0; i<arrayThreads.length; i++){
                        arrayThreads[i].join();
                    }
//                    testThread.join();
                    Date new_date = new Date();
                    String final_time = "\nTIME (ms) : "+ (new_date.getTime()-old_date.getTime());
                    textView.setText(finalResult+final_time);

                }catch (Exception e) {
                    textView.setText("error");
                };

            }

        });


    }
    public static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if(i % j == 0) { return false; }
        } return true;
    }

}














