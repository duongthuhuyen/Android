package com.example.beanikaa;

import com.example.beanikaa.result.Second_screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beanikaa.api.Api;
import com.example.beanikaa.result.Second_screen;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main_second extends AppCompatActivity {

    private Button congBtn, truBtn, cartBtn;
    private TextView amountTv, billTv;
    private ImageView heartImg;
    public int soLuong, tongTien;
    public String soLuongStr, foodIDstr, moneyStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_second);

        congBtn = findViewById(R.id.congBtn);
        truBtn = findViewById(R.id.truBtn);
        cartBtn = findViewById(R.id.cartBtn);
        amountTv = findViewById(R.id.amountTv);
        billTv = findViewById(R.id.billTv);
        heartImg = findViewById(R.id.heartImg);
        soLuong = Integer.parseInt(amountTv.getText().toString());


        heartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String backgroundImageName = String.valueOf(heartImg.getTag());
                if (backgroundImageName == "heart") {
                    heartImg.setImageResource(R.drawable.hearted);
                    heartImg.setTag("hearted");
                }
                else {
                    heartImg.setImageResource(R.drawable.heart);
                    heartImg.setTag("heart");
                }
            }
        });

        congBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soLuong++;
                amountTv.setText(String.valueOf(soLuong));
                tongTien = 55 * soLuong;
                billTv.setText(String.valueOf(tongTien) + ".000đ");
            }
        });

        truBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soLuong > 1) {
                    soLuong--;
                    amountTv.setText(String.valueOf(soLuong));
                    tongTien = 55 * soLuong;
                    billTv.setText(String.valueOf(tongTien) + ".000đ");
                }
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                foodIDstr = ......
//                soLuongStr = amountTv.getText().toString();
                callApiAdd2Cart(foodIDstr, soLuongStr);
            }
        });

    }

    private void callApiAdd2Cart(String foodIDstr, String soLuongStr) {
        RequestBody requestBodyFoodID = RequestBody.create(MediaType.parse("multipart/form-data"), foodIDstr);
        RequestBody requestBodyAmount = RequestBody.create(MediaType.parse("multipart/form-data"), soLuongStr);

        Api.apiAdd2Cart.add2cart(requestBodyFoodID, requestBodyAmount).enqueue(new Callback<Second_screen>() {
            @Override
            public void onResponse(Call<Second_screen> call, Response<Second_screen> response) {
                Second_screen result = response.body();
                if (result.getResult() == "sussesfull") {
                    Toast.makeText(Main_second.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Main_second.this, "Lỗi 1. Vui lòng thử lại", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Second_screen> call, Throwable t) {
                Toast.makeText(Main_second.this, "Lỗi mạng. Vui lòng thử lại", Toast.LENGTH_LONG).show();
            }
        });
    }
}