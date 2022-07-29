package com.example.sanpham.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.lib.Model.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lib.Model.Invoice;
import com.example.sanpham.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InvoiceAdapter extends  RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder> {

    private List<Invoice> list;
    public InvoiceAdapter (List<Invoice> list){
        this.list = list;
    }
    @NonNull
    @Override
    public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_item,parent,false);
        return new InvoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position) {
        Invoice product = list.get(position);
        if(product == null)
            return;
        List<product> temp = product.getLists();
        Picasso.get().load(temp.get(0).getImg()).into(holder.imgviewFood);
        holder.NgayDat.setText(product.getNgayDat());
        holder.Gia.setText(product.getTongTien());
    }

    @Override
    public int getItemCount() {
        if(list!= null)
            return  list.size();
        return 0;
    }

    public  class InvoiceViewHolder extends RecyclerView.ViewHolder{

        ImageView imgviewFood ;
        TextView NgayDat;
        TextView Gia;


        public InvoiceViewHolder(@NonNull View itemView) {
            super(itemView);
            imgviewFood = itemView.findViewById(R.id.Img_invoice);
            NgayDat = itemView.findViewById(R.id.txt_Ngaydat);
            Gia = itemView.findViewById(R.id.txt_tongTien);
        }

    }
}
