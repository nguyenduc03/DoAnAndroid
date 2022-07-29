package com.example.sanpham.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lib.Model.register;
import com.example.sanpham.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfimFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfimFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText txt_OTP;
    private Button btn_XacNhan;
    public register temp;
    private  View view;
    private  int count;
    private  int OTP;
    private ImageButton btn_back_DangKi ;


    public ConfimFragment(register temp) {
        this.temp = temp;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfimFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfimFragment newInstance(String param1, String param2) {
        ConfimFragment fragment = new ConfimFragment(new register ());
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
        view= inflater.inflate(R.layout.fragment_confim, container, false);

        count=5;
        OTP = 0000 ; // gán giá trị OTP
        AnhXaView();
        btn_XacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Check ();
            }
        });
        btn_back_DangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
        // Inflate the layout for this fragment
        return  view;
    }

    private void AnhXaView() {
        txt_OTP =view.findViewById(R.id.txt_OTP);
        btn_XacNhan = view.findViewById(R.id.btn_XacNhan);
        btn_back_DangKi = view.findViewById(R.id.btn_back_DangKi);

    }

    private void Check() {
        int OTP_input = Integer.parseInt(txt_OTP.getText().toString());
        if (OTP_input == OTP){
             // Dang ki thanh cong
        }
        else{
            if(count>0)
            count--;
            else{
                Toast.makeText(getContext(), "bạn đã nhập quá lần qua", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(getContext(), "Vui lòng kiểm tra lại mã OTP\n Bạn còn "+count+" lần", Toast.LENGTH_SHORT).show();
            txt_OTP.setText("");
        }
    }
}