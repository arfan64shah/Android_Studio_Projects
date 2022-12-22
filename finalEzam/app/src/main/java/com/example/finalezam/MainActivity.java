package com.example.finalezam;

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

    public void Prime(View V){

        EditText et1 = (EditText) findViewById(R.id.editTextNumber);

        int n1 = Integer.parseInt(et1.getText().toString());

        // Create and start a maximum of 10 threads
        for (int i = 0; i < n1; i++) {
            Thread thread = new Thread(new PrimeCalculator());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    private class PrimeCalculator implements Runnable {
        @Override
        public void run() {

            EditText et2 = (EditText) findViewById(R.id.editTextNumber2);
            EditText et3 = (EditText) findViewById(R.id.editTextNumber4);

            int n2 = Integer.parseInt(et2.getText().toString());
            // Calculate prime numbers here
            for (int i = 2; i <= n2; i++) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    et3.setText(i + " is prime");
                }
            }
        }
    }

}
