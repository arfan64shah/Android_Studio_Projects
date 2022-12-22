package com.example.authenticationapp;

public class Orders {
    private String bill;
    private String user;
    private String address;
    private int total;
    private String delivered;

    public Orders(String bill, String user, String address, int total) {
        this.bill = bill;
        this.user = user;
        this.address = address;
        this.total = total;
        this.delivered = "false";
    }

    public Orders(){

    }
    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = "true";
    }
}
