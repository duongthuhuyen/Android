package com.example.beanikaa.Model;

public class Food {
    private String foodname, thumbnail;
    private int sales;
    private float rating;

    public Food(String thumbnail, String foodname, int sales, float rating){
        this.thumbnail = thumbnail;
        this.foodname = foodname;
        this.sales = sales;
        this.rating = rating;
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
}
