package com.example.asus.sinistermanagment.Entites;

/**
 * Created by asus on 24/11/2017.
 */

public class Demande {
    private int id;

    private String  etat;
    private String type;
    private String oldMatriculation;
    private String newMatriculation;
    private String newMark;
    private String oldMark;
    private String color;
    private String horsePower;
    private String Model;

    public Demande() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOldMatriculation() {
        return oldMatriculation;
    }

    public void setOldMatriculation(String oldMatriculation) {
        this.oldMatriculation = oldMatriculation;
    }

    public String getNewMatriculation() {
        return newMatriculation;
    }

    public void setNewMatriculation(String newMatriculation) {
        this.newMatriculation = newMatriculation;
    }

    public String getNewMark() {
        return newMark;
    }

    public void setNewMark(String newMark) {
        this.newMark = newMark;
    }

    public String getOldMark() {
        return oldMark;
    }

    public void setOldMark(String oldMark) {
        this.oldMark = oldMark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }
}
