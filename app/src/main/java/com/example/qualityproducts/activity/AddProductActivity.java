package com.example.qualityproducts.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qualityproducts.R;
import com.example.qualityproducts.dao.AppDatabase;
import com.example.qualityproducts.databinding.ActivityAddProducerBinding;
import com.example.qualityproducts.databinding.ActivityAddProductBinding;
import com.example.qualityproducts.manager.ProductManager;
import com.example.qualityproducts.manager.UserManager;
import com.example.qualityproducts.model.Product;
import com.example.qualityproducts.model.User;
import com.example.qualityproducts.utils.ActivityUtils;
import com.squareup.picasso.Picasso;

public class AddProductActivity extends AppCompatActivity {
    private String    productImage;
    private static final int REQUEST_ADD_PRODUCT = 10;
    private ActivityAddProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_product);

        binding.addProductSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.addProductNameInput.getText().toString().isEmpty()
                        && !binding.addProductCaloricInput.getText().toString().isEmpty()
                        && !binding.addProductCarbohydratesInput.getText().toString().isEmpty()
                        && !binding.addProductProteinsInput.getText().toString().isEmpty()
                        && !binding.addProductFatsInput.getText().toString().isEmpty())
                {
                    Product product = new Product(binding.addProductNameInput.getText().toString(),
                            Double.valueOf(binding.addProductCaloricInput.getText().toString()),
                            Double.valueOf(binding.addProductCarbohydratesInput.getText().toString()),
                            Double.valueOf(binding.addProductProteinsInput.getText().toString()),
                            Double.valueOf(binding.addProductFatsInput.getText().toString()));

                    AppDatabase.getDatabase(AddProductActivity.this).productDao().insert(product);
                    ProductManager.getInstance().setProduct(product);
                    Intent intent = new Intent(AddProductActivity.this, ProductActivity.class);
                    intent.putExtra("productName", product.getName());
                    ActivityUtils.launchActivity(AddProductActivity.this, intent,true, true);
                } else {
                    Toast.makeText(AddProductActivity.this, "Informations manquantes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}