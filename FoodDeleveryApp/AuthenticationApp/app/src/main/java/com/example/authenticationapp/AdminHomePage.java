package com.example.authenticationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminHomePage extends AppCompatActivity {

    TextView goToAvailalbeFood;
    TextView goToAvailableDrinks;
    Button logout;
    ListView ordersListView; ///myListView
    List<Orders> ordersList; ///studentsList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        goToAvailalbeFood = findViewById(R.id.goToAvailableFood);
        goToAvailableDrinks = findViewById(R.id.goToAvailableDrink);
        logout = findViewById(R.id.logout);

        DatabaseReference pizzasdb;
        pizzasdb = FirebaseDatabase.getInstance("https://authenticationapp-b78e9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Orders");
        System.out.println("______________");
        System.out.println("______________");
        System.out.println("______________");
        System.out.println(pizzasdb);
        System.out.println("______________");
        System.out.println("______________");
        System.out.println("______________");
        ordersListView = findViewById(R.id.myOrdersListView);
        ordersList = new ArrayList<>();



        pizzasdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ordersList.clear();
                System.out.println("You made it till here");
                for (DataSnapshot pizzaDatasnap : snapshot.getChildren()){
                        Orders orders = pizzaDatasnap.getValue(Orders.class);
                        ordersList.add(orders);
                }
                OrdersListAdapter adopter = new OrdersListAdapter(AdminHomePage.this,ordersList);

                ordersListView.setAdapter(adopter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        goToAvailalbeFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AvailableFoods.class);
                startActivity(intent);
            }
        });

        goToAvailableDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AvailableDrinks.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(AdminHomePage.this, Login.class);
                startActivity(intent);
            }
        });
    }
}