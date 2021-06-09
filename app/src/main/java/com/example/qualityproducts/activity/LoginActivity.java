package com.example.qualityproducts.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.qualityproducts.R;
import com.example.qualityproducts.databinding.ActivityAddProducerBinding;
import com.example.qualityproducts.databinding.ActivityLoginBinding;
import com.example.qualityproducts.model.Producer;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_LOGIN = 13;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.loginSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });
    }
}