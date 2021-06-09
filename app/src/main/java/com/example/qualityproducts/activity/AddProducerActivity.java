package com.example.qualityproducts.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qualityproducts.R;
import com.example.qualityproducts.dao.AppDatabase;
import com.example.qualityproducts.databinding.ActivityAddProducerBinding;
import com.example.qualityproducts.manager.ProducerManager;
import com.example.qualityproducts.manager.UserManager;
import com.example.qualityproducts.model.Producer;
import com.example.qualityproducts.model.Product;
import com.example.qualityproducts.model.User;
import com.example.qualityproducts.utils.ActivityUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AddProducerActivity extends AppCompatActivity {
    private String    producerImage;
    private static final int REQUEST_ADD_PRODUCER = 13;
    private ActivityAddProducerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_producer);

        binding.addProducerSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (producerImage != null
                        && !binding.addProducerFirstnameInput.getText().toString().isEmpty()
                        && !binding.addProducerLastnameInput.getText().toString().isEmpty()
                        && !binding.addProducerAddressInput.getText().toString().isEmpty()
                        && !binding.addProducerProductListInput.getText().toString().isEmpty())
                {
                    Producer producer = new Producer(producerImage,// String.valueOf(registerImage)
                            binding.addProducerFirstnameInput.getText().toString(),
                            binding.addProducerLastnameInput.getText().toString(),
                            binding.addProducerAddressInput.getText().toString(),
                            "",
                            "",
                            "",
                            "",
                            (List<Product>) binding.addProducerProductListInput);

                    AppDatabase.getDatabase(AddProducerActivity.this).userDao().insert(producer);
                    ProducerManager.getInstance().setProducer(producer);
                    ActivityUtils.launchActivity(AddProducerActivity.this, MainActivity.class,true, true);
                } else {
                    Toast.makeText(AddProducerActivity.this, "Informations manquantes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD_PRODUCER && resultCode == RESULT_OK) {
            Picasso.get().load(data.getData()).centerCrop().fit().into(binding.addProducerImage);
            producerImage = data.getDataString();
        }
    }
}