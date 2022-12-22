package com.example.authenticationapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OrdersListAdapter extends ArrayAdapter {
    private Activity mContext;
    List<Orders> ordersList;

    public OrdersListAdapter(Activity mContext, List<Orders> ordersList){
        super(mContext,R.layout.list_item_order,ordersList);
        this.mContext = mContext;
        this.ordersList = ordersList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();

        View listItemView = inflater.inflate(R.layout.list_item_order,null,true);

        TextView bill = listItemView.findViewById(R.id.bill);
        TextView user = listItemView.findViewById(R.id.by);
        TextView address = listItemView.findViewById(R.id.address);
        TextView total = listItemView.findViewById(R.id.payment);
        Button btnDelivered = listItemView.findViewById(R.id.delivered);

        Orders orders = ordersList.get(position);

        bill.setText(orders.getBill());
        user.setText(orders.getUser());
        address.setText(orders.getAddress());
        total.setText(String.valueOf(orders.getTotal()));

        btnDelivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.setDelivered(true);
                Intent intent = new Intent(mContext.getApplicationContext(),AvailableFoods.class);
                mContext.startActivity(intent);
            }
        });

        return listItemView;

    }
}
