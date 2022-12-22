package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;

public class UserHomePage extends AppCompatActivity {

    Button orderPizzas;
    Button logout;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);
        orderPizzas = findViewById(R.id.orderPizza);
        logout = findViewById(R.id.logoutUser);
        message = findViewById(R.id.message);

        Intent caller = getIntent();
//        if (caller.getAction().equals(OrderDrink.this)) {
        try {
            boolean sent = (boolean) caller.getExtras().get("orderSent");
            System.out.println("was sent!" + sent);
            if(sent){
                message.setText("Your Order Was Accepted!\n" +
                        "You will be notified in a short notice!");
            }
        }catch (Exception e){
            System.out.println("just Started");
        }


        orderPizzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),OrderPizza.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(UserHomePage.this, Login.class);
                startActivity(intent);
            }
        });


    }
}