package com.example.authenticationapp;

public class Drinks {
    private String drinkUrl;
    private String drinkName;
    private int drinkPrice;
    private boolean available;

    public Drinks(String drinkName, String drinkUrl, int drinkPrice) {
        this.drinkName = drinkName;
        this.drinkUrl = drinkUrl;
        this.drinkPrice = drinkPrice;
        this.available = true;
    }

    public Drinks() {
        this.drinkName = "drinkName";
        this.drinkUrl = "";
        this.drinkPrice = 0;
        this.available = true;
    }

    public String getDrinkUrl() {
        return drinkUrl;
    }

    public void setDrinkUrl(String drinkUrl) {
        this.drinkUrl = drinkUrl;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(int drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
