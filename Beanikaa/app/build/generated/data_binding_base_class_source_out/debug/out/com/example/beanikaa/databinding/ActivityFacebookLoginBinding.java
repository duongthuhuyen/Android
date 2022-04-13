// Generated by view binder compiler. Do not edit!
package com.example.beanikaa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.beanikaa.R;
import com.facebook.login.widget.LoginButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFacebookLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView email;

  @NonNull
  public final TextView firstName;

  @NonNull
  public final LoginButton loginButton;

  @NonNull
  public final TextView name;

  private ActivityFacebookLoginBinding(@NonNull LinearLayout rootView, @NonNull TextView email,
      @NonNull TextView firstName, @NonNull LoginButton loginButton, @NonNull TextView name) {
    this.rootView = rootView;
    this.email = email;
    this.firstName = firstName;
    this.loginButton = loginButton;
    this.name = name;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFacebookLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFacebookLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_facebook_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFacebookLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.email;
      TextView email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.first_name;
      TextView firstName = ViewBindings.findChildViewById(rootView, id);
      if (firstName == null) {
        break missingId;
      }

      id = R.id.login_button;
      LoginButton loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      return new ActivityFacebookLoginBinding((LinearLayout) rootView, email, firstName,
          loginButton, name);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
