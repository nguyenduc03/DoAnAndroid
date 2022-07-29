package com.example.sanpham.Fragment;

import android.Manifest;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lib.Model.UserInfo;
import com.example.sanpham.MainActivity;
import com.example.sanpham.R;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.io.IOException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gun0912.tedbottompicker.TedBottomPicker;
import gun0912.tedbottompicker.TedBottomSheetDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserInfo userInfo ;

    public Profile_Fragment() {
        // Required empty public constructor
    }
    public Profile_Fragment(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile_Fragment newInstance(String param1, String param2) {
        Profile_Fragment fragment = new Profile_Fragment();
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
    View view;
    CircleImageView circleImageView;
    Button btn_dangxuat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.profile_fragment, container, false);
       ImageView imageView = view.findViewById(R.id.profile_imageView);
        /*String temp = "https://photo.wikivui.com/20/02/con-vit-duck.jpg http://i.imgur.com/DvpvklR.png";
        String[] url= temp.split(" ");*/
        /*Random rd = new Random();*/
        //Picasso.get().load(url[rd.nextInt(url.length)]).into(imageView);

//        TextView ten  = view.findViewById(R.id.profile_ten);
//
//        TextView sdt  = view.findViewById(R.id.profile_sdt);
//        TextView username  = view.findViewById(R.id.profile_Username);
//        TextView role  = view.findViewById(R.id.profile_Role);
//        ten.setText(userInfo.getFullname());
//        sdt.setText(userInfo.getPhone());
//        username.setText(userInfo.getUsername());
//        if(userInfo.getRole() == "true")
//            role.setText("Admin");
//        else role.setText("User");
        Button btn_chonHinh = view.findViewById(R.id.btn_chonHinh);

        btn_chonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XinQuyen();
            }

            public void Chonhinh() {
                // Show va load hinh trong thu vien
                TedBottomPicker.with(getActivity())
                        .show(new TedBottomSheetDialogFragment.OnImageSelectedListener() {
                            @Override
                            public void onImageSelected(Uri uri) {
                                Bitmap bitmap = null;
                                try {
                                    bitmap = MediaStore.Images.Media.getBitmap(view.getContext().getContentResolver(), uri);
                                    imageView.setImageBitmap(bitmap);

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });


            }

            private void XinQuyen() {
                // xin quyen thu vien anh
                PermissionListener permissionlistener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        Chonhinh();
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(view.getContext(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                    }


                };
                TedPermission.create()
                        .setPermissionListener(permissionlistener)
                        .setDeniedMessage("Bạn phải cho phép ứng dụng sử dụng các quyền")
                        .setPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                        .check();
            }
        });
        btn_dangxuat = view.findViewById(R.id.btn_dangxuat);
        btn_dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity = (MainActivity) getActivity();
                activity.setTaiKhoan(null);
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment = new NonUserProfileFragment();
                fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
                fragmentTransaction.addToBackStack("Fragment home");
                fragmentTransaction.commit();
            }
        });

        return  view;
    }
}