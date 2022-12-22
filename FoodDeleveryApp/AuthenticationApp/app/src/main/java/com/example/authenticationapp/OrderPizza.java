package com.example.authenticationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderPizza extends AppCompatActivity {

    TextView goToDrinks;
    ListView availablePizzasListView; ///myListView
    List<Pizzas> pizzasList; ///studentsList

    HashMap<String,Integer> map;
    HashMap<String,Integer> priceMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pizza);
        DatabaseReference pizzasdb;
        pizzasdb = FirebaseDatabase.getInstance("https://authenticationapp-b78e9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Pizzas");
        goToDrinks = findViewById(R.id.goToDrinks);
        availablePizzasListView = findViewById(R.id.availablePizzasListView);
        pizzasList = new ArrayList<>();


        pizzasdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pizzasList.clear();

                for (DataSnapshot pizzaDatasnap : snapshot.getChildren()){
                    Pizzas pizzas = pizzaDatasnap.getValue(Pizzas.class);
                    pizzasList.add(pizzas);
                }
                userFoodListAdapter adopter = new userFoodListAdapter(OrderPizza.this,pizzasList);
                map = adopter.map;
                priceMap = adopter.priceMap;
                availablePizzasListView.setAdapter(adopter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        goToDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("_____________");
                System.out.println("_____________");
                System.out.println("_____________");
                System.out.println(map.toString());
                System.out.println("_____________");
                System.out.println("_____________");
                Intent intent = new Intent(getApplicationContext(),OrderDrink.class);
                intent.putExtra("order",map);
                intent.putExtra("priceMap",priceMap);
                startActivity(intent);
            }
        });
    }


}