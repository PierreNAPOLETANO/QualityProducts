package com.example.qualityproducts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qualityproducts.databinding.FragmentProductBinding;
import com.example.qualityproducts.manager.ProductManager;
import com.example.qualityproducts.model.Product;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String name          = ProductManager.getInstance().getProduct().getName();
    private Double caloric       = ProductManager.getInstance().getProduct().getCaloric();
    private Double carbohydrates = ProductManager.getInstance().getProduct().getCarbohydrates();
    private Double proteins      = ProductManager.getInstance().getProduct().getProteins();
    private Double fats          = ProductManager.getInstance().getProduct().getFats();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentProductBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false);
        Product product = ProductManager.getInstance().getProduct();

        binding.productName.setText(product.getName());
        binding.productCaloric.setText(product.getCaloric().toString());
        binding.productCarbohydrates.setText(product.getCarbohydrates().toString());
        binding.productProteins.setText(product.getProteins().toString());
        binding.productFats.setText(product.getFats().toString());

        return inflater.inflate(R.layout.fragment_product, container, false);
    }
}