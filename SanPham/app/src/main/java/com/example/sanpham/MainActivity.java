package com.example.sanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.*;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib.Interface.IChuyenData;
import com.example.lib.Interface.IChuyenTaiKhoan;
import com.example.lib.Model.UserInfo;
import com.example.lib.Model.product;
import com.example.sanpham.Fragment.CartFragment;
import com.example.sanpham.Fragment.Fragment_detail;
import com.example.sanpham.Fragment.HomeFragment;
import com.example.sanpham.Fragment.InvoiceFragment;
import com.example.sanpham.Fragment.LiveFragment;
import com.example.sanpham.Fragment.NonUserProfileFragment;
import com.example.sanpham.Fragment.Profile_Fragment;
import com.example.sanpham.Fragment.fragmentproduct;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.io.Serializable;

import gun0912.tedbottompicker.TedBottomPicker;

public class MainActivity extends AppCompatActivity implements IChuyenData, IChuyenTaiKhoan, Serializable {

    public MainActivity() {

    }

    ChipNavigationBar ChipNavigationBar;
    Context context;

    private UserInfo taiKhoan;
    public TedBottomPicker tedBottomPicker;


    public UserInfo getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(UserInfo taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public MainActivity(UserInfo taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        ChipNavigationBar = findViewById(R.id.menu_1);
        ChipNavigationBar.setItemSelected(R.id.fragment_home, true);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, new HomeFragment());
        fragmentTransaction.addToBackStack("Fragment home");
        fragmentTransaction.commit();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            taiKhoan = (UserInfo) bundle.getSerializable("data");
            Toast.makeText(this, taiKhoan.getUsername(), Toast.LENGTH_SHORT).show();
        } else if (bundle == null) {
            Toast.makeText(this, "Bundle is null", Toast.LENGTH_SHORT).show();
        }
        MenuClick();
    }


    private void MenuClick() {
        ChipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                Fragment fragment = null;
                switch (i) {
                    case R.id.fragment_home:

                        fragment = new HomeFragment();
                        break;
                    case R.id.fragmentInvoice:
                        fragment = new InvoiceFragment();
                        break;

                    case R.id.menu_nav_buy: // mở giỏ hàng

                        fragment = new CartFragment();
                        break;

                    case R.id.fragmentproduct:
                        if (taiKhoan == null)
                            // nếu không có tài khoản thì
                            fragment = new fragmentproduct();
                            // ngược lại thì
                        else
                            fragment = new fragmentproduct(taiKhoan);

                        break;

                    case R.id.menu_nav_user:
                        if (taiKhoan == null)
                            // nếu không có tài khoản thì
//                            fragment = new NonUserProfileFragment();
                            fragment = new Profile_Fragment();

                            // ngược lại thì
                        else
                            fragment = new Profile_Fragment(taiKhoan);

                        break;

                }
                fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
                fragmentTransaction.addToBackStack("Fragment home");
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void ChuyenData(product p) {

        Bundle bundle = new Bundle();
        Serializable x = p;
        bundle.putSerializable("product", x);
        Fragment_detail temp = new Fragment_detail();
        temp.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, temp).commit();
        fragmentTransaction.addToBackStack("Fragment Detail");
    }

    @Override
    public void Chuyen_TongTien(int sum) {
        TextView TongTien1 = findViewById(R.id.TongTien);
        TongTien1.setText("$ " + String.valueOf(sum));
    }

}