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

public class LoginScreen extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    private static final String TAG = LoginScreen.class.getName();
    TextInputEditText Phone_field, Pass_field;
    Button loginbtn;
    ImageButton fbLoginBtn, ggLoginBtn;
    ProgressBar progressBar;
    TextView forgotpass, loginActBtn;
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
        loginActBtn = findViewById(R.id.toLoginActBtn);

        //Facebook & Gg buttons
        fbLoginBtn = findViewById(R.id.facebookbtn);
        ggLoginBtn = findViewById(R.id.googlebtn);


        Phone_field.setHint("Your phone number");
        Pass_field.setHint("Password");

        Phone_field.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    Phone_field.setHint("");
                else
                    Phone_field.setHint("Your phone number");
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

//<<<<<<< HEAD
                        PutData putData = new PutData("http://192.168.188.243//Beanikaa/login.php", "POST", field, data);
//=======
//                        PutData putData = new PutData("http://192.168.0.102/android/login", "POST", field, data);
//>>>>>>> 021603ec38cd8d1f52762da787e0b082906bd764
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if(result!= null){
                                    progressBar.setVisibility(View.GONE);
                                    SendMail sendMail = new SendMail(LoginScreen.this,"huyen.dtt19010061@st.phenikaa-uni.edu.vn","hi","hello");
                                    sendMail.send();

                                    //ObjectMapper objectMapper = new ObjectMapper();
                                //    Account.account = objectMapper.readValue(result,User.class);
                                   //Account.account= new Gson().fromJson(result,User.class);
                                   // String s ="{\"id\":\"1\",\"password\":\"1234\",\"email\":\"huyen\",\phoneNumber"\":\"01234567\",\"created_date\":\"2022-03-04 16:25:49\",\"created_by\":null,\"modified_date\":\"2022-03-04 16:25:49\",\"modified_by\":null,\"idRole\":\"0\"}";
                                   // Account.account= new Gson().fromJson(s,User.class);
                                    //System.out.println(Account.account);

                                    Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(getApplicationContext(),"no thing",Toast.LENGTH_SHORT).show();
                                }
                               /* String result = putData.getResult();
                                if(result.equals("Dang nhap thanh cong!")){
                                    progressBar.setVisibility(View.GONE);
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                }*/
                               // checkLogin("http://192.168.0.102/android/login");
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

        //Already had account, login
        loginActBtn.setOnClickListener(new View.OnClickListener() {
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
}