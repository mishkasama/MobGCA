package com.example.yekkenyosr.pi.Entites;

/**
 * Created by Yekken Yosr on 26/11/2017.
 */

public class Vehicule {
    private String Matriculation;
    private int NumChassis;
    private String Mark;
    private String Model;
    private String Color;
    private String HorsePower;

    @Override
    public String toString() {
        return "Vehicule{" +
                "Matriculation='" + Matriculation + '\'' +
                ", NumChassis=" + NumChassis +
                ", Mark='" + Mark + '\'' +
                ", Model='" + Model + '\'' +
                ", Color='" + Color + '\'' +
                ", HorsePower='" + HorsePower + '\'' +
                '}';
    }

    public String getMatriculation() {
        return Matriculation;
    }

    public void setMatriculation(String matriculation) {
        Matriculation = matriculation;
    }

    public int getNumChassis() {
        return NumChassis;
    }

    public void setNumChassis(int numChassis) {
        NumChassis = numChassis;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getHorsePower() {
        return HorsePower;
    }

    public void setHorsePower(String horsePower) {
        HorsePower = horsePower;
    }
}
