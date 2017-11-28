package com.example.fakhr.insurancee.Entites;

import java.util.Date;

/**
 * Created by fakhr on 24/11/2017.
 */

public class Insurance {
    private int Id;
    private String nameInsurance;
    private String phone;
    private String mail;
    private String description;
    private Date dateCreation;
    private String laltitude;
    private String longitude;
    private Address address;

    public String getLaltitude() {
        return laltitude;
    }

    public void setLaltitude(String laltitude) {
        this.laltitude = laltitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Address getAdress() {
        return address;
    }

    public void setAdress(Address address) {
        this.address = address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameInsurance() {
        return nameInsurance;
    }

    public void setNameInsurance(String nameInsurance) {
        this.nameInsurance = nameInsurance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }



    public Insurance(String nameInsurance, String phone, String mail, String description, Date dateCreation) {
        this.nameInsurance = nameInsurance;
        this.phone = phone;
        this.mail = mail;
        this.description = description;
        this.dateCreation = dateCreation;
    }

    public Insurance() {
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "nameInsurance='" + nameInsurance + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", description='" + description + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
