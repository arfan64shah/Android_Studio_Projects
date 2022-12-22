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

public class OrderDrink extends AppCompatActivity {
    TextView goToOrder;
    ListView availableDrinksListView; ///myListView
    List<Drinks> drinksList; ///studentsList
    HashMap<String, Integer> data_map;
    HashMap<String,Integer> map;
    HashMap<String,Integer> priceMap;
    HashMap<String,Integer> updatedPriceMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_drink);
        DatabaseReference pizzasdb;
        pizzasdb = FirebaseDatabase.getInstance("https://authenticationapp-b78e9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Drinks");
        goToOrder = findViewById(R.id.goToOrder);
        availableDrinksListView = findViewById(R.id.availableDrinksListView);
        drinksList = new ArrayList<>();

        Intent caller = getIntent();
//        if (caller.getAction().equals(OrderDrink.this)) {
        data_map = (HashMap<String, Integer>)caller.getExtras().get("order");
        priceMap = (HashMap<String, Integer>)caller.getExtras().get("priceMap");
//        }

        System.out.println("you are in drinks");
        System.out.println("_______________");
        System.out.println("_______________");
        System.out.println("_______________");
        System.out.println(data_map.toString());
        System.out.println("_______________");
        System.out.println("_______________");
        System.out.println("_______________");

        pizzasdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                drinksList.clear();

                for (DataSnapshot pizzaDatasnap : snapshot.getChildren()){
                    Drinks drinks = pizzaDatasnap.getValue(Drinks.class);
                    drinksList.add(drinks);
                }
                UserDrinkListAdapter adopter = new UserDrinkListAdapter(OrderDrink.this,drinksList,data_map,priceMap);
                map = adopter.map;
                updatedPriceMap = adopter.priceMap;

                availableDrinksListView.setAdapter(adopter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        goToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                intent.putExtra("orders",map);
                intent.putExtra("priceMap",priceMap);
                startActivity(intent);
                System.out.println("go to order was clicked!");
                System.out.println(map.toString());
                System.out.println(priceMap.toString());


            }
        });
    }
}