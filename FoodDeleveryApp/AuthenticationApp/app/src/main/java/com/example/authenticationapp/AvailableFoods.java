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
import java.util.List;

public class AvailableFoods extends AppCompatActivity {

    TextView addNewPizza;
    ListView myAdminAvailableFoodListView; ///myListView
    List<Pizzas> pizzasList; ///studentsList


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_foods);

        DatabaseReference pizzasdb;
        pizzasdb = FirebaseDatabase.getInstance("https://authenticationapp-b78e9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Pizzas");
        myAdminAvailableFoodListView = findViewById(R.id.availablePizzasListView);
        pizzasList = new ArrayList<>();
        pizzasdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pizzasList.clear();

                for (DataSnapshot pizzaDatasnap : snapshot.getChildren()){
                    Pizzas pizzas = pizzaDatasnap.getValue(Pizzas.class);
                    pizzasList.add(pizzas);
                }
                AdminAvailableFoodListAdopter adopter = new AdminAvailableFoodListAdopter(AvailableFoods.this,pizzasList);

                myAdminAvailableFoodListView.setAdapter(adopter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addNewPizza = findViewById(R.id.addNewPizza);

        addNewPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewPizza.class);
                startActivity(intent);
                
            }
        });
    }
}