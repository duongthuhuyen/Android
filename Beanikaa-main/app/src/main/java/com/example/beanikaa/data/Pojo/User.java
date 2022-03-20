package com.example.beanikaa.data.Pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private int id;
    private String password;
    private String email;
    private String 	phoneNumber;
    private Date created_date;
    private String created_by;
    private Date modified_date;
    private String modified_by;
    private int idRole;

    public User(int id, String password,String email,String phoneNumber, Date created_date, String created_by, Date modified_date, String modified_by, int idRole) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.created_date = created_date;
        this.created_by = created_by;
        this.modified_date = modified_date;
        this.modified_by = modified_by;
        this.idRole = idRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}
