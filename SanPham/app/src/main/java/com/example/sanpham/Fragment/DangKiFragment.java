package com.example.sanpham.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lib.Model.register;
import com.example.sanpham.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DangKiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DangKiFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    TextView username, name, phone;
    EditText password;
    private View result;
    public DangKiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DangKiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DangKiFragment newInstance(String param1, String param2) {
        DangKiFragment fragment = new DangKiFragment();
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
        result = inflater.inflate(R.layout.fragment_dangki, container, false);;
        anhxa();
        Button btn = result.findViewById(R.id.dangki);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solve();
            }
        });
        // Inflate the layout for this fragment
        return result ;
    }

    public void anhxa(){
        username = result.findViewById(R.id.username);
        name = result.findViewById(R.id.fullname);
        phone = result.findViewById(R.id.phone);
        password = result.findViewById(R.id.password);
    }

    public void solve() {
        register temp = new register();
        temp.setUsername(username.getText().toString());
        temp.setPassword(password.getText().toString());
        temp.setFullName(name.getText().toString());
        temp.setPhone(phone.getText().toString());

        // Chuyen data qua

        Fragment fragment = new ConfimFragment(temp);
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.addToBackStack("Fragment home");
        fragmentTransaction.commit();
    }
}