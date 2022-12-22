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

public class UserDrinkListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Drinks> drinksList;
    HashMap<String, Integer> map;
    HashMap<String, Integer> priceMap;

    public UserDrinkListAdapter(Activity mContext, List<Drinks> drinksList, HashMap<String, Integer> data_map, HashMap<String, Integer> priceMap){
        super(mContext,R.layout.list_food_user,drinksList);
        this.mContext = mContext;
        this.drinksList = drinksList;
        this.map = data_map;
        this.priceMap = priceMap;
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

        Drinks drinks = drinksList.get(position);

        pzName.setText(drinks.getDrinkName());

        loadImage(drinks.getDrinkUrl(),pzUrl);
        pzPrice.setText(String.valueOf(drinks.getDrinkPrice()));

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt((String) pzCount.getText()) + 1;
                pzCount.setText(String.valueOf(count));
                String name = pzName.getText().toString();
                if (map.containsKey(name)){
                    map.put(name,count);
                }
                else {
                    map.put(name,1);
                    priceMap.put(name,drinks.getDrinkPrice());
                }
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt((String) pzCount.getText()) - 1;
                if(count > 0 ) {
                    pzCount.setText(String.valueOf(count));
                    String name = pzName.getText().toString();
                    if (map.containsKey(name)){
                        map.put(name,count);
                    }
                    else {
                        map.put(name,1);
                        priceMap.put(name,drinks.getDrinkPrice());
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
