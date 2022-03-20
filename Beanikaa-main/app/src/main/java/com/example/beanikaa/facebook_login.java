package com.example.beanikaa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class facebook_login extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;
    TextView Tvname, Tvemail, Tvfirst_name;
    String name, email, first_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_facebook_login);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        Tvname = (TextView) findViewById(R.id.name);
        Tvemail = (TextView) findViewById(R.id.email);
        Tvfirst_name = (TextView) findViewById(R.id.first_name);

        Tvname.setVisibility(View.INVISIBLE);
        Tvemail.setVisibility(View.INVISIBLE);
        Tvfirst_name.setVisibility(View.INVISIBLE);

        callbackManager = CallbackManager.Factory.create();

        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        setLogin_Button();
    }

    private void setLogin_Button() {
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                loginButton.setVisibility(View.INVISIBLE);
                Tvname.setVisibility(View.VISIBLE);
                Tvemail.setVisibility(View.VISIBLE);
                Tvfirst_name.setVisibility(View.VISIBLE);
                result();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void result() {
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("JSON", response.getJSONObject().toString());
                try {
                    email = object.getString("email");
                    name = object.getString("name");
                    first_name = object.getString("first_name");

                    Tvname.setText(name);
                    Tvemail.setText(email);
                    Tvfirst_name.setText(first_name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "name, email, first_name");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        LoginManager.getInstance().logOut();
        super.onStart();
    }
}