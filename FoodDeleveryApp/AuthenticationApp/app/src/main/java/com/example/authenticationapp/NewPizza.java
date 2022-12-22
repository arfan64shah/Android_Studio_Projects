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

public class NewPizza extends AppCompatActivity {

    TextView nameOfPizza;
    TextView urlToPizza;
    TextView priceOfPizza;
    Button addPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pizza);
        nameOfPizza = findViewById(R.id.pizzaName);
        urlToPizza = findViewById(R.id.pizzaUrl);
        priceOfPizza = findViewById(R.id.pizzaPrice);
        addPizza = findViewById(R.id.addPizza);

        DatabaseReference pizzasdb;
        pizzasdb = FirebaseDatabase.getInstance("https://authenticationapp-b78e9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Pizzas");

        addPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namePizza = nameOfPizza.getText().toString();
                String urlPizza = urlToPizza.getText().toString();
                int pizzaPrice = Integer.parseInt(priceOfPizza.getText().toString());

                Pizzas pizzas1 = new Pizzas(namePizza,urlPizza,pizzaPrice);
                pizzasdb.push().setValue(pizzas1);
                Intent intent = new Intent(getApplicationContext(),AvailableFoods.class);
                startActivity(intent);
                Toast.makeText(NewPizza.this,"Data inserted!",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
