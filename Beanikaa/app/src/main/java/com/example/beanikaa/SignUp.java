package com.example.beanikaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText phone,email,password,confirmpassword;
    Button exitbutton,registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    private void Id_link(){
        phone = (EditText)findViewById(R.id.phone);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        confirmpassword = (EditText)findViewById(R.id.confirmpassword);
        registerbutton = (Button)findViewById(R.id.registertbutton);
    }
}