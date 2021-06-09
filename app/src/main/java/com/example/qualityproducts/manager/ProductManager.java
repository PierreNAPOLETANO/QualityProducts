package com.example.qualityproducts.manager;

import com.example.qualityproducts.model.Product;

public class ProductManager {
    private static ProductManager instance;
    private Product product;

    public static ProductManager getInstance()
    {
        if (instance == null)
            instance = new ProductManager();

        return instance;
    }

    public static void setInstance(ProductManager instance)
    {
        ProductManager.instance = instance;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
