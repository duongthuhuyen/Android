package com.example.beanikaa.Model;

public class Orders {
    private String name, thumbnail;
    private double price;
    private int amount;
    private float rating;
    private int status;

    public Orders (String thumbnail, String name, double price, int amount, float rating, int status){
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.amount = amount;
        this.rating = rating;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
