package com.example.qualityproducts.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qualityproducts.R;
import com.example.qualityproducts.dao.AppDatabase;
import com.example.qualityproducts.databinding.ActivityRegisterBinding;
import com.example.qualityproducts.manager.UserManager;
import com.example.qualityproducts.model.User;
import com.example.qualityproducts.utils.ActivityUtils;
import com.squareup.picasso.Picasso;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private static final int REQUEST_IMAGE = 7;
    private String registerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        binding.registerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, REQUEST_IMAGE);
            }
        });

        binding.registerSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (registerImage != null && !binding.registerFirstnameInput.getText().toString().isEmpty()
                    && !binding.registerLastnameInput.getText().toString().isEmpty() && !binding.registerAddressInput.getText().toString().isEmpty()
                    && !binding.registerZipcodeInput.getText().toString().isEmpty() && !binding.registerCityInput.getText().toString().isEmpty()
                    && !binding.registerEmailInput.getText().toString().isEmpty() && !binding.registerPasswordInput.getText().toString().isEmpty())
                {
                    User user = new User(registerImage,
                                         binding.registerFirstnameInput.getText().toString(),
                                         binding.registerLastnameInput.getText().toString(),
                                         binding.registerAddressInput.getText().toString(),
                                         binding.registerZipcodeInput.getText().toString(),
                                         binding.registerCityInput.getText().toString(),
                                         binding.registerEmailInput.getText().toString(),
                                         binding.registerPasswordInput.getText().toString());

                    AppDatabase.getDatabase(RegisterActivity.this).userDao().insert(user);
                    UserManager.getInstance().setUser(user);
                    ActivityUtils.launchActivity(RegisterActivity.this, MainActivity.class,true, true);
                } else {
                    Toast.makeText(RegisterActivity.this, "Informations manquantes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            Picasso.get().load(data.getData()).centerCrop().fit().into(binding.registerImage);
            registerImage = data.getDataString();
        }
    }
}