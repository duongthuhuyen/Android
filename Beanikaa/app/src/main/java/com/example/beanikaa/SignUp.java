package com.example.beanikaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp extends AppCompatActivity {

    EditText phoneInfo,emailInfo,passwordInfo,confirmpasswordInfo;
    Button exitbutton,registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        phoneInfo = findViewById(R.id.phoneField);
//        //Start ProgressBar first (Set visibility VISIBLE)
//        Handler handler = new Handler(Looper.getMainLooper());
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                String[] field = new String[2];
//                field[0] = "param-1";
//                field[1] = "param-2";
//                field[2] = "";
//                field[3] = "";
//
//                String[] data = new String[2];
//                data[0] = "data-1";
//                data[1] = "data-2";
//                data[2] = "data-1";
//                data[3] = "data-2";
//
//                PutData putData = new PutData("http://192.168.0.107//Beanikaa/signup.php", "POST", field, data);
//                if (putData.startPut()) {
//                    if (putData.onComplete()) {
//                        String result = putData.getResult();
//                        //End ProgressBar (Set visibility to GONE)
//                        Log.i("PutData", result);
//                    }
//                }
//                //End Write and Read data with URL
//            }
//        });
    }
}