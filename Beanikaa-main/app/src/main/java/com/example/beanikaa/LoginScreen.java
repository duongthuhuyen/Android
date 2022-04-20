package com.example.beanikaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.beanikaa.Adapter.FoodRecyclerAdapter;
import com.example.beanikaa.Model.Food;
import com.example.beanikaa.Service.SendMail;
import com.example.beanikaa.common.Account;
import com.example.beanikaa.data.Pojo.User;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.textfield.TextInputEditText;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginScreen extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    private static final String TAG = LoginScreen.class.getName();
    TextInputEditText Phone_field, Pass_field;
    Button loginbtn;
    ImageButton fbLoginBtn, ggLoginBtn;
    ProgressBar progressBar;
    TextView forgotpass, SignUpActBtn;
    private GoogleApiClient googleApiClient;
    private static final int SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        loginbtn = findViewById(R.id.LoginBtn);
        progressBar = findViewById(R.id.progress);
        Phone_field = findViewById(R.id.phone_field);
        Pass_field = findViewById(R.id.password_field);
        SignUpActBtn = findViewById(R.id.toLoginActBtn);

        //Facebook & Gg buttons
        fbLoginBtn = findViewById(R.id.facebookbtn);
        ggLoginBtn = findViewById(R.id.googlebtn);


        Phone_field.setHint("Your email");
        Pass_field.setHint("Password");

        Phone_field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    Phone_field.setHint("");
                else
                    Phone_field.setHint("Your email");
            }
        });
        Pass_field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    Pass_field.setHint("");
                else
                    Pass_field.setHint("Password");
            }
        });


        //xu ly du lieu
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(Phone_field.getText());
                password = String.valueOf(Pass_field.getText());

                if (!email.equals("") && !password.equals("")){

                    progressBar.setVisibility(View.VISIBLE);

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        //Starting Write and Read data with URL (url của localhost)
                        //Creating array for parameters
                        String[] field = new String[2];
                        field[0] = "email";
                        field[1] = "password";

                        //Creating array for data
                        String[] data = new String[2];
                        data[0] = email;
                        data[1] = password;


//                       PutData putData = new PutData("http://192.168.188.243//Beanikaa/login.php", "POST", field, data);

                        PutData putData = new PutData(Account.link + "login.php", "POST", field, data);


                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                                if(result!= null){
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(getApplicationContext(),"nothing",Toast.LENGTH_SHORT).show();
                                }

                                if(result.contains("Login Success!")){
                                    progressBar.setVisibility(View.GONE);
                                    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                });
            }
                else {
                    Toast.makeText(getApplicationContext(),"Số điện thoại hoặc mật khẩu để trống",Toast.LENGTH_LONG).show();
                }
            }

        });


        //Facebook login
        fbLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), facebook_login.class);
                startActivity(intent);
            }
        });


        //Google login
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();
        ggLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, SIGN_IN);
            }
        });

        //To sign up screen
        SignUpActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
    }
    public void checkLogin(String url){

        RequestQueue mRequestQueue= Volley.newRequestQueue(this);;
        StringRequest mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG,"Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult){
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if(result.isSuccess()){
                startActivity(new Intent(LoginScreen.this, MainActivity.class));
                finish();
            }
            else{
                Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void getAccount_info(String login_result_url){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, login_result_url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i<=jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);

                        String thumbnail = object.getString("img");
                        String foodname = object.getString("foodName");

                        double rating = object.getDouble("foodRating");
                        String str_rate = String.valueOf(rating);
                        float rate = Float.valueOf(str_rate);

                        int sales = object.getInt("sales");
                        double price = object.getDouble("price");
                        String address = object.getString("address");


                        Food aFood = new Food(thumbnail, foodname, sales, rate, price, address);
                    }
                } catch (JSONException e) {}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginScreen.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(LoginScreen.this).add(stringRequest);

    }

}