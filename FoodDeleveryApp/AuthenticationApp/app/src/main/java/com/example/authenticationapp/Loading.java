package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Loading extends AppCompatActivity {
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();
        System.out.println("_____________");
        System.out.println("_____________");
        System.out.println(user);
        System.out.println("_____________");
        System.out.println("_____________");
//        System.out.println(user.getEmail());
        NextActivity(user);
    }


    public void NextActivity(FirebaseUser user)
    {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = null;
                if (user == null) {
                    mainIntent  = new Intent(Loading.this, Login.class);
                    System.out.println("you are here 1");
                }
                else if (user.getDisplayName() == null || user.getDisplayName().length() == 0){
                    mainIntent  = new Intent(Loading.this, AdminHomePage.class);
                    System.out.println("you are here 2");
                }
                else {
                    System.out.println("You are here!");
                    System.out.println(user.getDisplayName().length());
                    mainIntent  = new Intent(Loading.this, UserHomePage.class);
                    System.out.println("you are here 3");
                }
                Loading.this.startActivity(mainIntent);
                Loading.this.finish();
            }
        }, 2000);

    }
}