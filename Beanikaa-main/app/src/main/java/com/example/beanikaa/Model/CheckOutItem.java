package com.example.beanikaa.Model;

public class CheckOutItem {
    private int idorder, number, idfoodnew;
    private double price;
    private String foodname;

    public CheckOutItem(int idorder, int number, int idfoodnew, String foodname, double price) {
        this.price = price;
        this.idorder = idorder;
        this.number = number;
        this.idfoodnew = idfoodnew;
        this.foodname = foodname;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIdfoodnew() {
        return idfoodnew;
    }

    public void setIdfoodnew(int idfoodnew) {
        this.idfoodnew = idfoodnew;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double a_total(){
        return price*number;
    }
}
