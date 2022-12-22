package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {
    HashMap<String,Integer> map;
    HashMap<String,Integer> priceMap;
    TextView billTextView;
    TextView totalPrice;
    EditText deliveryAddress;
    Button order;
    FirebaseAuth fAuth;

    String bill = "";
    int overall = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        billTextView = findViewById(R.id.bill);
        totalPrice = findViewById(R.id.total);
        deliveryAddress = findViewById(R.id.delivaryAddress);
        order = findViewById(R.id.Order);
        fAuth = FirebaseAuth.getInstance();

        Intent caller = getIntent();
        map = (HashMap<String, Integer>)caller.getExtras().get("orders");
        priceMap = (HashMap<String, Integer>)caller.getExtras().get("priceMap");

        for (Map.Entry<String, Integer> set :
                map.entrySet()) {
            bill = bill + set.getKey() + " " + set.getValue() + " x " +
                    priceMap.get(set.getKey()) + " = " + (set.getValue() * priceMap.get(set.getKey())) + "\n";
            overall = overall + set.getValue() * priceMap.get(set.getKey());

        }
        billTextView.setText(bill);
        totalPrice.setText("Total Payment _____ " + overall);
        DatabaseReference pizzasdb;
        pizzasdb = FirebaseDatabase.getInstance("https://authenticationapp-b78e9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Orders");


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dAddress = deliveryAddress.getText().toString();
                String name = fAuth.getCurrentUser().getDisplayName();
                System.out.println(name);
                if (dAddress.length() < 5){
                    deliveryAddress.setError("Enter a proper address");
                    return;
                }

                Orders order = new Orders(bill,name,dAddress,overall);
                pizzasdb.push().setValue(order);
                Intent intent = new Intent(getApplicationContext(),UserHomePage.class);
                intent.putExtra("orderSent",true);
                startActivity(intent);
                Toast.makeText(OrderActivity.this,"Order received!",Toast.LENGTH_SHORT).show();








            }
        });
    }
}