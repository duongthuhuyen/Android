package com.example.beanikaa.Model;

public class Food {
    private String foodname, thumbnail, address;
    private int sales, price;
    private float rating;

    public Food(String thumbnail, String foodname, int sales, float rating, int price, String address){
        this.thumbnail = thumbnail;
        this.foodname = foodname;
        this.sales = sales;
        this.rating = rating;
        this.price = price;
        this.address = address;
    }

    public String getfoodname() {
        return foodname;
    }

    public void setfoodname(String name) {
        this.foodname = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
