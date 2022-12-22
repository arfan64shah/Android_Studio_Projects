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

public class AvailableDrinks extends AppCompatActivity {
    TextView addNewDrink;
    ListView myAdminAvailableDrinkListView; ///myListView
    List<Drinks> drinksList; ///studentsList
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_drinks);

        DatabaseReference pizzasdb;
        pizzasdb = FirebaseDatabase.getInstance("https://authenticationapp-b78e9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Drinks");
        myAdminAvailableDrinkListView = findViewById(R.id.myAdminAvailableDrinkListView);
        drinksList = new ArrayList<>();
        pizzasdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                drinksList.clear();

                for (DataSnapshot pizzaDatasnap : snapshot.getChildren()){
                    Drinks pizzas = pizzaDatasnap.getValue(Drinks.class);
                    drinksList.add(pizzas);
                }
                AdminAvailableDrinkListAdopter adopter = new AdminAvailableDrinkListAdopter(AvailableDrinks.this,drinksList);

                myAdminAvailableDrinkListView.setAdapter(adopter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addNewDrink = findViewById(R.id.addNewDrink);

        addNewDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewDrink.class);
                startActivity(intent);

            }
        });
    }
}