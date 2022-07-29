// Generated by view binder compiler. Do not edit!
package com.example.sanpham.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sanpham.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProfileFragmentBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnDangxuat;

  @NonNull
  public final TextView detailMoTa;

  @NonNull
  public final LinearLayout panelColor;

  @NonNull
  public final ImageView profileImageView;

  @NonNull
  public final EditText profileRole;

  @NonNull
  public final EditText profileSdt;

  @NonNull
  public final EditText profileTen;

  @NonNull
  public final TextView profileUsername;

  private ProfileFragmentBinding(@NonNull FrameLayout rootView, @NonNull Button btnDangxuat,
      @NonNull TextView detailMoTa, @NonNull LinearLayout panelColor,
      @NonNull ImageView profileImageView, @NonNull EditText profileRole,
      @NonNull EditText profileSdt, @NonNull EditText profileTen,
      @NonNull TextView profileUsername) {
    this.rootView = rootView;
    this.btnDangxuat = btnDangxuat;
    this.detailMoTa = detailMoTa;
    this.panelColor = panelColor;
    this.profileImageView = profileImageView;
    this.profileRole = profileRole;
    this.profileSdt = profileSdt;
    this.profileTen = profileTen;
    this.profileUsername = profileUsername;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProfileFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProfileFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.profile_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProfileFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_dangxuat;
      Button btnDangxuat = ViewBindings.findChildViewById(rootView, id);
      if (btnDangxuat == null) {
        break missingId;
      }

      id = R.id.detail_MoTa;
      TextView detailMoTa = ViewBindings.findChildViewById(rootView, id);
      if (detailMoTa == null) {
        break missingId;
      }

      id = R.id.panel_color;
      LinearLayout panelColor = ViewBindings.findChildViewById(rootView, id);
      if (panelColor == null) {
        break missingId;
      }

      id = R.id.profile_imageView;
      ImageView profileImageView = ViewBindings.findChildViewById(rootView, id);
      if (profileImageView == null) {
        break missingId;
      }

      id = R.id.profile_Role;
      EditText profileRole = ViewBindings.findChildViewById(rootView, id);
      if (profileRole == null) {
        break missingId;
      }

      id = R.id.profile_sdt;
      EditText profileSdt = ViewBindings.findChildViewById(rootView, id);
      if (profileSdt == null) {
        break missingId;
      }

      id = R.id.profile_ten;
      EditText profileTen = ViewBindings.findChildViewById(rootView, id);
      if (profileTen == null) {
        break missingId;
      }

      id = R.id.profile_Username;
      TextView profileUsername = ViewBindings.findChildViewById(rootView, id);
      if (profileUsername == null) {
        break missingId;
      }

      return new ProfileFragmentBinding((FrameLayout) rootView, btnDangxuat, detailMoTa, panelColor,
          profileImageView, profileRole, profileSdt, profileTen, profileUsername);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
