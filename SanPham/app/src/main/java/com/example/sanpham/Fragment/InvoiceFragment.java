package com.example.sanpham.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lib.Model.Invoice;
import com.example.lib.Model.product;
import com.example.sanpham.Adapter.FoodAdapter;
import com.example.sanpham.Adapter.InvoiceAdapter;
import com.example.sanpham.Adapter.ProductAdapter;
import com.example.sanpham.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InvoiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InvoiceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView List_invoice ;
    View view ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InvoiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InvoiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InvoiceFragment newInstance(String param1, String param2) {
        InvoiceFragment fragment = new InvoiceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_invoice, container, false);
        List_invoice = view.findViewById(R.id.List_invoice);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        List_invoice.setLayoutManager(gridLayoutManager);
        FoodAdapter InvoiceAdapter = new FoodAdapter(GetList());
        List_invoice.setAdapter(InvoiceAdapter);
        return view;
    }

    private List<product> GetList() {

        List<product> mListener = new ArrayList<>();

        List<product> listProduct = new ArrayList<>();
        product product = new product();
        product.setProductId("123");
        product.setCPU("abc");
        product.setImg("https://dean2020.edu.vn/wp-content/uploads/2020/03/anh-cho-con.jpg");
        product.setInPrice("123");
        product.setProductNumber("12343");
        product.setRAM("3gb");
        product.setProductName("halo");
        product.setOutPrice("90000");
        listProduct.add(product);
        listProduct.add(product);
        listProduct.add(product);
        listProduct.add(product);
        listProduct.add(product);
        listProduct.add(product);
        listProduct.add(product);
        listProduct.add(product);
//        Invoice invoice = new Invoice(1,"12/12/1212",12000,listProduct);
//        mListener.add(invoice);
//        mListener.add(invoice);
//        mListener.add(invoice);
        return listProduct;
    }
}