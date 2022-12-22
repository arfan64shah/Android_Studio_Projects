package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewDrink extends AppCompatActivity {
    TextView nameOfDrink;
    TextView urlToDrink;
    TextView priceOfDrink;
    Button addDrink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drink);
        nameOfDrink = findViewById(R.id.drinkName);
        urlToDrink = findViewById(R.id.drinkUrl);
        priceOfDrink = findViewById(R.id.drinkPrice);
        addDrink = findViewById(R.id.addDrink);

        DatabaseReference pizzasdb;
        pizzasdb = FirebaseDatabase.getInstance("https://authenticationapp-b78e9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Drinks");

        addDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameOfDrink.getText().toString();
                String url = urlToDrink.getText().toString();
                int price = Integer.parseInt(priceOfDrink.getText().toString());

                Drinks drink = new Drinks(name,url,price);
                pizzasdb.push().setValue(drink);
                Intent intent = new Intent(getApplicationContext(),AvailableDrinks.class);
                startActivity(intent);
                Toast.makeText(NewDrink.this,"Data inserted!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}