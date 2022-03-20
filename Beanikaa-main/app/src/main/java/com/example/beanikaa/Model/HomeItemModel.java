package com.example.beanikaa.Model;

public class HomeItemModel {
    private int image;
    private String addresstxt;
    private Double starttxt;
    private String inf;//(++200)

    public HomeItemModel(int image, String addresstxt, Double starttxt, String inf) {
        this.image = image;
        this.addresstxt = addresstxt;
        this.starttxt = starttxt;
        this.inf = inf;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAddresstxt() {
        return addresstxt;
    }

    public void setAddresstxt(String addresstxt) {
        this.addresstxt = addresstxt;
    }

    public Double getStarttxt() {
        return starttxt;
    }

    public void setStarttxt(Double starttxt) {
        this.starttxt = starttxt;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }
}
