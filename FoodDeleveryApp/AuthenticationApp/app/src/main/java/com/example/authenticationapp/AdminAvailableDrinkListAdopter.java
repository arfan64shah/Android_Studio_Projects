package com.example.authenticationapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdminAvailableDrinkListAdopter extends ArrayAdapter {
    private Activity mContext;
    List<Drinks> drinksList;

    public AdminAvailableDrinkListAdopter(Activity mContext, List<Drinks> drinksList){
        super(mContext,R.layout.list_available_food_admin,drinksList);
        this.mContext = mContext;
        this.drinksList = drinksList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();

        View listItemView = inflater.inflate(R.layout.list_available_food_admin,null,true);

        TextView pzName = listItemView.findViewById(R.id.adminDisplayPizzaName);
        ImageView pzUrl = listItemView.findViewById(R.id.adminDisplayUrlToPizza);
        TextView pzPrice = listItemView.findViewById(R.id.adminDisplayPizzaPrice);

        Drinks drinks = drinksList.get(position);

        pzName.setText(drinks.getDrinkName());
        System.out.println("_____________");
        System.out.println("_____________");
        System.out.println("_____________");

//        System.out.println("URL: " + drinks.getDrinkUrl());
//        System.out.println("Price: " + drinks.getPizzaPrice());
//        pzUrl.setText(pizzas.getPizzaUrl());
        loadImage(drinks.getDrinkUrl(),pzUrl);
        pzPrice.setText(String.valueOf(drinks.getDrinkPrice()));

        return listItemView;

    }

    private void loadImage(String url, ImageView urlToImage) {
        Picasso.get()
                .load(url)

                .into(urlToImage);
    }
}
