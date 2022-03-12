package com.example.beanikaa;

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

import com.google.android.material.textfield.TextInputEditText;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginScreen extends AppCompatActivity {
    private static final String TAG = LoginScreen.class.getName();
    TextInputEditText Phone_field, Pass_field;
    Button loginbtn;
    ProgressBar progressBar;
    TextView forgotpass;

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
                String phonenumber, password;
                phonenumber = String.valueOf(Phone_field.getText());
                password = String.valueOf(Pass_field.getText());

                if (!phonenumber.equals("") && !password.equals("")){

                    progressBar.setVisibility(View.VISIBLE);

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL (url của localhost)
                        //Creating array for parameters
                        String[] field = new String[2];
                        field[0] = "phoneNumber";
                        field[1] = "password";

                        //Creating array for data
                        String[] data = new String[2];
                        data[0] = phonenumber;
                        data[1] = password;

                        PutData putData = new PutData("http://192.168.0.102/android/login", "POST", field, data);
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
}