package com.example.qualityproducts.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qualityproducts.R;
import com.example.qualityproducts.databinding.ActivityLoginBinding;
import com.example.qualityproducts.databinding.ActivityProducerBinding;

public class ProducerActivity extends AppCompatActivity {
    private static final int REQUEST_PRODUCER = 10;
    private ActivityProducerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_producer);
    }
}