package com.example.qualityproducts.manager;

import com.example.qualityproducts.model.Producer;
import com.example.qualityproducts.model.User;

public class ProducerManager extends User {
    private static ProducerManager instance;
    private Producer producer;

    public ProducerManager(String image, String firstname, String lastname, String address, String zipcode, String city, String email, String password) {
        super(image, firstname, lastname, address, zipcode, city, email, password);
    }

    public static ProducerManager getInstance()
    {
        if (instance == null)
            instance = new ProducerManager("", "", "", "","", "", "", "");

        return instance;
    }

    public static void setInstance(ProducerManager instance)
    {
        ProducerManager.instance = instance;
    }

    public Producer getProducer()
    {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
