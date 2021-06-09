package com.example.qualityproducts.model;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @NonNull
    @PrimaryKey
    private String image;
    private String firstname;
    private String lastname;
    private String address;
    private String zipcode;
    private String type;
    private String city;
    private String email;
    private String password;

    public User(String image, String firstname, String lastname, String address, String zipcode, String city, String email, String password)
    {
        setImage(image);
        setFirstname(firstname);
        setLastname(lastname);
        setAddress(address);
        setZipcode(zipcode);
        setCity(city);
        setEmail(email);
        setPassword(password);
    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
