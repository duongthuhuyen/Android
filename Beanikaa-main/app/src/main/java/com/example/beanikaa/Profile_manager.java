package com.example.beanikaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile_manager extends AppCompatActivity {

    TextView order_history_tx, log_out_tx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_manager);

        order_history_tx = findViewById(R.id.order_btn);
        log_out_tx = findViewById(R.id.logout_btn);

        order_history_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OrderHistory.class);
                startActivity(intent);
            }
        });


        log_out_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences user_account_info = getSharedPreferences("Login", MODE_PRIVATE);
                SharedPreferences.Editor Ed = user_account_info.edit();
                Ed.putBoolean("isLoggedin", false);
                Ed.commit();
                Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(intent);
            }
        });



    }


}