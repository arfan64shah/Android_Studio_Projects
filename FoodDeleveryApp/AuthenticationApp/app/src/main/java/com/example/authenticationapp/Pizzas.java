package com.example.authenticationapp;

public class Pizzas {

    private String pizzaUrl;
    private String pizzaName;
    private int pizzaPrice;
    private boolean available;

    public Pizzas(String pizzaName, String pizzaUrl, int pizzaPrice) {
        this.pizzaName = pizzaName;
        this.pizzaUrl = pizzaUrl;
        this.pizzaPrice = pizzaPrice;
        this.available = true;
    }

    public Pizzas() {
        this.pizzaName = "pizzaName";
        this.pizzaUrl = "";
        this.pizzaPrice = 0;
        this.available = true;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getPizzaUrl() {
        return pizzaUrl;
    }

    public int getPizzaPrice() {
        return pizzaPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public void setPizzaUrl(String pizzaUrl) {
        this.pizzaUrl = pizzaUrl;
    }

    public void setPizzaPrice(int pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
