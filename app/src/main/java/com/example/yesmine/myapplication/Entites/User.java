package com.example.yekkenyosr.pi.Entites;

import java.util.Date;

/**
 * Created by Yekken Yosr on 26/11/2017.
 */

public class User {
    public static int CurrentId ;
    public static String CurrentName ;
    public static Date CurrentBirthdayDate ;
    public static String CurrentAdress ;
    public static String CurrentEmail ;
    public static String CurrentPhone ;
    public static String CurrentLogin ;
    public static String CurrentPassword ;
    public static String CurrentRole ;

    private int id;
    private String name;
    private Date BirthdayDate;
    private String adress;
    private String email;
    private String phone;
    private String login;
    private String password;
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", BirthdayDate=" + BirthdayDate +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
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

    public Date getBirthdayDate() {
        return BirthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        BirthdayDate = birthdayDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
