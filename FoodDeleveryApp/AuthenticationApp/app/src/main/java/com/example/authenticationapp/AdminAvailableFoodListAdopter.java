package com.example.authenticationapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdminAvailableFoodListAdopter extends ArrayAdapter {

    private Activity mContext;
    List<Pizzas> pizzasList;

    public AdminAvailableFoodListAdopter(Activity mContext, List<Pizzas> pizzasList){
        super(mContext,R.layout.list_available_food_admin,pizzasList);
        this.mContext = mContext;
        this.pizzasList = pizzasList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();

        View listItemView = inflater.inflate(R.layout.list_available_food_admin,null,true);

        TextView pzName = listItemView.findViewById(R.id.adminDisplayPizzaName);
        ImageView pzUrl = listItemView.findViewById(R.id.adminDisplayUrlToPizza);
        TextView pzPrice = listItemView.findViewById(R.id.adminDisplayPizzaPrice);

        Pizzas pizzas = pizzasList.get(position);

        pzName.setText(pizzas.getPizzaName());
        System.out.println("_____________");
        System.out.println("_____________");
        System.out.println("_____________");

        System.out.println("URL: " + pizzas.getPizzaUrl());
        System.out.println("Price: " + pizzas.getPizzaPrice());
//        pzUrl.setText(pizzas.getPizzaUrl());
        loadImage(pizzas.getPizzaUrl(),pzUrl);
        pzPrice.setText(String.valueOf(pizzas.getPizzaPrice()));

        return listItemView;

    }

    private void loadImage(String url, ImageView urlToImage) {
        Picasso.get()
                .load(url)

                .into(urlToImage);
    }


}
