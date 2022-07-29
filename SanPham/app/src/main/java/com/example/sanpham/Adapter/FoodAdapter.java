package com.example.sanpham.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lib.Model.product;
import com.example.sanpham.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<product> list;

    public FoodAdapter(List<product> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.san_pham, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        product product = list.get(position);
        if (product == null)
            return;
        Picasso.get().load(product.getImg()).into(holder.imgviewFood);
        holder.Name.setText(product.getProductName());
        holder.Gia.setText(product.getOutPrice());
        holder.MoTa.setText(product.getProductId());
        holder.Item_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // item click
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView imgviewFood;
        TextView Name;
        TextView MoTa;
        RelativeLayout Item_product;
        TextView Gia;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgviewFood = itemView.findViewById(R.id.img_sanpham);
            Item_product = itemView.findViewById(R.id.Item_product_1);
            Name = itemView.findViewById(R.id.ten_sanpham);
            MoTa = itemView.findViewById(R.id.mota_sanpham);
            Gia = itemView.findViewById(R.id.gia_sanpham);


        }

    }
}
