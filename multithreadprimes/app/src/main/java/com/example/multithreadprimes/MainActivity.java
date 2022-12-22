package com.example.multithreadprimes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText numThreads;
    EditText maxInt;
    TextView output;
    TextView exectime;
    Button calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numThreads = findViewById(R.id.threadNums);
        maxInt = findViewById(R.id.numPrimes);
        output = findViewById(R.id.output);
        exectime = findViewById(R.id.executionTime);
        calc = findViewById(R.id.calc);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<PrimeNumber> primeNumbers = new ArrayList<>();
                System.out.println("I am clicked");
                String nthreads = numThreads.getText().toString();
                String integernum = maxInt.getText().toString();
                System.out.println(nthreads);
                System.out.println(integernum);

                if (nthreads.length() == 0){
                    numThreads.setError("Specify a number between 1 and 10");
                    return;
                }

                if (Integer.parseInt(nthreads) < 1 || Integer.parseInt(nthreads) >10){
                    numThreads.setError("Number between 1 and 10");
                    return;
                }

                if (maxInt.getText().toString().length() == 0){
                    maxInt.setError("Input an integer");
                    return;
                }

                int mint = Integer.parseInt(integernum);
                int nt = Integer.parseInt(nthreads);
                int first = 2;
                int step = ((mint-first) / nt) + 1;

                System.out.println("Start: " + Time.SECOND);

                Date date1 = new Date();

                long a =date1.getTime();
                System.out.println(a);

                for (int i = 1; i < Integer.parseInt(nthreads)+1; i++) {
//                    System.out.println("thread " + (i+1));
                    int last;
                    if (first + step > mint){
                        last = mint;
                    }
                    else {
                        last = first + step;
                    }
                    PrimeNumber primes = new PrimeNumber(first,last,i);
                    primes.start();
                    primeNumbers.add(primes);