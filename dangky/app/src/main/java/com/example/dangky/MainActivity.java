package com.example.dangky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phone,email,password,confirmpassword;
    Button exitbutton,registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void Id_link(){
        phone = (EditText)findViewById(R.id.phone);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        confirmpassword = (EditText)findViewById(R.id.confirmpassword);
        exitbutton = (Button)findViewById(R.id.exitbutton);
        registerbutton = (Button)findViewById(R.id.registertbutton);
    }
}