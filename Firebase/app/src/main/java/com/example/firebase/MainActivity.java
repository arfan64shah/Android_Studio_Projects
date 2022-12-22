package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void WriteInfotoFirebase (View view){
// Write a message to the database
// Get the database instance and store into object
        FirebaseDatabase database = FirebaseDatabase.getInstance();
// getReference() gets the reference if the reference is already created...
// if reference is not created then it will create a new reference here
        DatabaseReference myRef = database.getReference("message");
// assign value to the particular reference
        myRef.setValue("Hello, World! Time-date is "+
                Calendar.getInstance().getTime());
        myRef = database.getReference("message1").child("java").child("user");
        myRef.setValue("Hello, World! Time-date is "+ Calendar.getInstance().getTime());
    }
}