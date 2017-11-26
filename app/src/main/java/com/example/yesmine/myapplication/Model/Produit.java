package com.example.yesmine.myapplication.Model;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Entity Product.
 */
public class Produit implements Serializable {
    private int id;
    private String image;
    private String text;
    private String title;
    private int note;
    private int nombreRate;
    private int rate;
    private float moyenneRate;
    private Assurance assurance;
    private Blob product_image;


    public Produit() {
    }

    public Produit(int id, String image, String text, String title, int note, int nombreRate, int rate, float moyenneRate, Assurance assurance) {
        this.id = id;
        this.image = image;
        this.text = text;
        this.title = title;
        this.note = note;
        this.nombreRate = nombreRate;
        this.rate = rate;
        this.moyenneRate = moyenneRate;
        this.assurance = assurance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
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

    public float getMoyenneRate() {
        return moyenneRate;
    }

    public void setMoyenneRate(float moyenneRate) {
        this.moyenneRate = moyenneRate;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public Blob getProduct_image() {
        return product_image;
    }

    public void setProduct_image(Blob product_image) {
        this.product_image = product_image;
    }
}
