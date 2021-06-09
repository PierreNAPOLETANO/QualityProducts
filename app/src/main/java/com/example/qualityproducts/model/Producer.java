package com.example.qualityproducts.model;

import java.util.List;

public class Producer extends User {
    private List<Product> products;

    public Producer(String image, String firstname, String lastname, String address, String zipcode, String city, String email, String password, List<Product> products) {
        super(image, firstname, lastname, address, zipcode, city, email, password);
        setProducts(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
