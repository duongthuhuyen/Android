package com.example.beanikaa.Model;

public class UserAccount {
    private String email, phonenumber;
    private int id;

    public UserAccount(int id, String email, String phonenumber){
        this.id = id;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
