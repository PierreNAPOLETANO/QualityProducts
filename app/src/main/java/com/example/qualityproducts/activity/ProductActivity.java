package com.example.qualityproducts.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qualityproducts.R;
import com.example.qualityproducts.dao.AppDatabase;
import com.example.qualityproducts.databinding.ActivityProducerBinding;
import com.example.qualityproducts.databinding.ActivityProductBinding;
import com.example.qualityproducts.manager.ProductManager;
import com.example.qualityproducts.model.Product;

public class ProductActivity extends AppCompatActivity {

    private String name          = ProductManager.getInstance().getProduct().getName();
    private Double caloric       = ProductManager.getInstance().getProduct().getCaloric();
    private Double carbohydrates = ProductManager.getInstance().getProduct().getCarbohydrates();
    private Double proteins      = ProductManager.getInstance().getProduct().getProteins();
    private Double fats          = ProductManager.getInstance().getProduct().getFats();

    private ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        Product product = AppDatabase.getDatabase(this).productDao().getProduct(getIntent()
                .getStringExtra("productName"));

        // binding.productCaloric.setText(String.valueOf(product.getCaloric()));
    }
}