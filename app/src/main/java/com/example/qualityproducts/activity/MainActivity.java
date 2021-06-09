package com.example.qualityproducts.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.qualityproducts.R;
import com.example.qualityproducts.adapter.ProductAdapter;
import com.example.qualityproducts.dao.AppDatabase;
import com.example.qualityproducts.databinding.ActivityLoginBinding;
import com.example.qualityproducts.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.productRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.productRecycler.setAdapter(new ProductAdapter(AppDatabase.getDatabase(this).productDao().getAllProducts()));

        binding.addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });


    }
}