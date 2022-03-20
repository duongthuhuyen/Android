package com.example.beanikaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    EditText usernameInfo, phoneInfo,emailInfo,passwordInfo,confirmpasswordInfo;
    TextView loginActBtn;
    Button registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameInfo = findViewById(R.id.nameField);
        phoneInfo = findViewById(R.id.phoneField);
        emailInfo = findViewById(R.id.emailField);
        passwordInfo = findViewById(R.id.passwordField);
        confirmpasswordInfo = findViewById(R.id.confirmpasswordField);

        loginActBtn = findViewById(R.id.toLoginActBtn);
        registerbutton = findViewById(R.id.registertbtn);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username, password, confirmpass, email, phonenumber;
                username = String.valueOf(usernameInfo.getText());
                password = String.valueOf(passwordInfo.getText());
                confirmpass = String.valueOf(confirmpasswordInfo.getText());
                email = String.valueOf(emailInfo.getText());
                phonenumber = String.valueOf(phoneInfo.getText());

                if (username.equals("") && email.equals("") && phonenumber.equals("") && password.equals("") && confirmpass.equals(""))
                    Toast.makeText(getApplicationContext(),"Please fill all the fields!",Toast.LENGTH_LONG).show();

                 else if (!CheckPhone(phonenumber)) Toast.makeText(getApplicationContext(),"Your phone number is not valid!",Toast.LENGTH_LONG).show();

                 else if (!CheckEmail(email)) Toast.makeText(getApplicationContext(),"Your email address is not available!",Toast.LENGTH_LONG).show();

                 else if (!password.equals(confirmpass)) Toast.makeText(getApplicationContext(),"Password not matched!",Toast.LENGTH_LONG).show();

                 else if(!CheckPassword(password)) Toast.makeText(getApplicationContext(),"Password must has at least 8 characters, 1 upper case alphabet, 1 number and 1 special character!",Toast.LENGTH_LONG).show();

                 else {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[4];
                            field[0] = "username";
                            field[1] = "password";
                            field[2] = "email";
                            field[3] = "phoneNumber";

                            String[] data = new String[4];
                            data[0] = username;
                            data[1] = password;
                            data[2] = email;
                            data[3] = phonenumber;

                            PutData putData = new PutData("http://192.168.0.107//Beanikaa/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    //End ProgressBar (Set visibility to GONE)

                                    if (result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(),"Sign up success!",Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
            }
        });

        //Already had account, login
        loginActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(intent);
            }
        });
    }

    //Kiem tra mat khau
    public boolean CheckPassword(String pass) {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=*])(?=\\S+$).{8,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pass);

        return matcher.matches();
    }

    //Kiem tra sdt
    public boolean CheckPhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(phone).matches();
        }
    }

    //Kiem tra email
    public static boolean CheckEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}