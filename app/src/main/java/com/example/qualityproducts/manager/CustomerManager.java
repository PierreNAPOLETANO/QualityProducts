package com.example.qualityproducts.manager;

import com.example.qualityproducts.model.User;

public class CustomerManager extends User {
    public CustomerManager(String firstname, String lastname, String address, String zipcode, String city, String email, String password) {
        super("", firstname, lastname, address, zipcode, city, email, password);
    }
}
