package com.example.qualityproducts.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qualityproducts.R;
import com.example.qualityproducts.activity.MainActivity;
import com.example.qualityproducts.activity.ProductActivity;
import com.example.qualityproducts.dao.ProductDao;
import com.example.qualityproducts.model.Product;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<Product> products;
    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @NotNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_row, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductHolder holder, int position) {
        Product product = products.get(position);
        holder.name.setText(product.getName());
        holder.caloric.setText(product.getCaloric().toString());
        holder.carbohydrates.setText(product.getCarbohydrates().toString());
        holder.proteins.setText(product.getProteins().toString());
        holder.fats.setText(product.getFats().toString());

       /* binding.productName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    class ProductHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView caloric;
        public TextView carbohydrates;
        public TextView proteins;
        public TextView fats;

        ProductHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            caloric = itemView.findViewById(R.id.product_caloric);
            carbohydrates = itemView.findViewById(R.id.product_carbohydrates);
            proteins = itemView.findViewById(R.id.product_proteins);
            fats = itemView.findViewById(R.id.product_fats);
        }
    }
}
