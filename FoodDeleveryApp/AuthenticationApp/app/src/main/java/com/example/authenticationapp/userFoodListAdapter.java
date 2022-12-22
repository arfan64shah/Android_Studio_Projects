package com.example.authenticationapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userFoodListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Pizzas> pizzasList;
    HashMap<String,Integer> map=new HashMap<String,Integer>();
    HashMap<String,Integer> priceMap=new HashMap<String,Integer>();

    public userFoodListAdapter(Activity mContext, List<Pizzas> pizzasList){
        super(mContext,R.layout.list_food_user,pizzasList);
        this.mContext = mContext;
        this.pizzasList = pizzasList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_food_user,null,true);
        TextView pzName = listItemView.findViewById(R.id.adminDisplayPizzaName);
        ImageView pzUrl = listItemView.findViewById(R.id.adminDisplayUrlToPizza);
        TextView pzPrice = listItemView.findViewById(R.id.adminDisplayPizzaPrice);
        TextView pzCount = listItemView.findViewById(R.id.count);

        Button up = listItemView.findViewById(R.id.add);
        Button down = listItemView.findViewById(R.id.subtract);

        Pizzas pizzas = pizzasList.get(position);

        pzName.setText(pizzas.getPizzaName());

        loadImage(pizzas.getPizzaUrl(),pzUrl);
        pzPrice.setText(String.valueOf(pizzas.getPizzaPrice()));

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt((String) pzCount.getText())+1;
                pzCount.setText(String.valueOf(count));
                String name = pzName.getText().toString();
                if (map.containsKey(name)){
                    map.put(name,count);
                }
                else {
                    map.put(name,1);
                    priceMap.put(name,pizzas.getPizzaPrice());
                }
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt((String) pzCount.getText()) - 1;
                if(count >= 0 ) {
                    pzCount.setText(String.valueOf(count));
                    String name = pzName.getText().toString();
                    if (map.containsKey(name)){
                        map.put(name,count);
                    }
                    else {
                        map.put(name,1);
                        priceMap.put(name,pizzas.getPizzaPrice());
                    }
                }
            }
        });


        return listItemView;



    }

    private void loadImage(String url, ImageView urlToImage) {
        Picasso.get()
                .load(url)

                .into(urlToImage);
    }
}