package com.example.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Food_checkout extends AppCompatActivity {

    private Button backBtn;
    private TextView food;
    private TextView address;
    private Button change_addressBtn;
    private TextView subtotal;
    private TextView shipping;
    private Button couponBtn;
    private Button ibankingBtn;
    private Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Food_checkout);

        backBtn = findViewById(R.id.back_button);
        change_addressBtn = findViewById(R.id.change_address);
        couponBtn = findViewById(R.id.coupon);
        ibankingBtn = findViewById(R.id.ibanking);
        orderBtn = findViewById(R.id.order);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent());
            }
        });

        change_addressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent());
            }
        });

        couponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent());
            }
        });

        ibankingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent());
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent());
            }
        });
    }
}