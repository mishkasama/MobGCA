package com.example.yesmine.myapplication.Model;

import java.io.Serializable;

/**
 * Entity Assurance.
 */
public class Assurance implements Serializable {
    private int id;
    private String name;
    private int phone;
    private String email;
    private String description;
    private int nombreRate;
    private int rate;


    public Assurance() {
    }

    public Assurance(int id, String name, int phone, String email, String description, int nombreRate, int rate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.nombreRate = nombreRate;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombreRate() {
        return nombreRate;
    }

    public void setNombreRate(int nombreRate) {
        this.nombreRate = nombreRate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
