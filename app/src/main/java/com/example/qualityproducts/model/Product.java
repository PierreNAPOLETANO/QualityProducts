package com.example.qualityproducts.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @NonNull
    @PrimaryKey
    private String name;
    private Double caloric;
    private Double carbohydrates;
    private Double proteins;
    private Double fats;

    public Product(String name, Double caloric, Double carbohydrates, Double proteins, Double fats)
    {
        setName(name);
        setCaloric(caloric);
        setCarbohydrates(carbohydrates);
        setProteins(proteins);
        setFats(fats);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCaloric() {
        return caloric;
    }

    public void setCaloric(Double caloric) {
        this.caloric = caloric;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }
}
