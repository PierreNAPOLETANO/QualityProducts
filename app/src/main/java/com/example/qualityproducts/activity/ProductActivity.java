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

    private ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product);

        Product product = AppDatabase.getDatabase(this).productDao().getProduct(getIntent()
                .getStringExtra("productName"));

        // binding.productCaloric.setText(String.valueOf(product.getCaloric()));
        String name;
        String caloric;
        String carbonhydrate;
        String protein;
        String fat;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                name = null;
            } else {
                name = extras.getString("name");
            }
        } else {
            name = (String) savedInstanceState.getSerializable("name");
        }

        Product theProduct = AppDatabase.getDatabase(this).productDao().getProduct(name);
        binding.productName.setText(theProduct.getName());
        binding.productCaloric.setText(String.valueOf(theProduct.getCaloric()));
        binding.productCarbohydrates.setText(String.valueOf(theProduct.getCarbohydrates()));
        binding.productFats.setText(String.valueOf(theProduct.getFats()));
        binding.productProteins.setText(String.valueOf(theProduct.getProteins()));

        binding.productRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}