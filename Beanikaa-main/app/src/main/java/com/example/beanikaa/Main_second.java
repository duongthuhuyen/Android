package com.example.beanikaa;

import com.example.beanikaa.common.Account;
import com.example.beanikaa.result.Second_screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beanikaa.api.Api;
import com.example.beanikaa.result.Second_screen;
import com.squareup.picasso.Picasso;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main_second extends AppCompatActivity {

    private Button congBtn, truBtn, cartBtn;
    private TextView amountTv, billTv;
    private ImageView heartImg, gioHangImg, fImg, fImg2, fImg3;
    public int soLuong;
    public double tongTien;
    public String soLuongStr, foodIDstr, moneyStr;

    private Intent intent;

    private TextView fName, fAddress, fRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        intent = getIntent();
        int foodID = (int) intent.getIntExtra("id", 0);
        String foodName = (String) intent.getStringExtra("name");
        String foodAddress = (String) intent.getStringExtra("address");
        float foodRating = (float) intent.getFloatExtra("rating", 2);
        double foodPrice = (double) intent.getDoubleExtra("price", 2d);
        String foodImage = (String) intent.getStringExtra("thumbnail");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_second);

        congBtn = findViewById(R.id.congBtn);
        truBtn = findViewById(R.id.truBtn);
        cartBtn = findViewById(R.id.addcartBtn);
        amountTv = findViewById(R.id.amountTv);
        billTv = findViewById(R.id.billTv);
        heartImg = findViewById(R.id.heartImg);
        gioHangImg = findViewById(R.id.showcart_btn);
        soLuong = Integer.parseInt(amountTv.getText().toString());

        fName = findViewById(R.id.FoodNameTv);
        fAddress = findViewById(R.id.addressTv);
        fRating = findViewById(R.id.ratingTv);
        fImg = findViewById(R.id.img1);
        fImg2 = findViewById(R.id.img2);
        fImg3 = findViewById(R.id.img3);

        fName.setText(foodName);
        fAddress.setText(foodAddress);
        fRating.setText(String.valueOf(foodRating));
        Picasso.get().load(foodImage).into(fImg);
        Picasso.get().load(foodImage).into(fImg2);
        Picasso.get().load(foodImage).into(fImg3);
        billTv.setText(String.valueOf(foodPrice) + "đ");

        gioHangImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent123 = new Intent(Main_second.this, CheckOut.class);
                startActivity(intent123);
            }
        });

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
                tongTien = foodPrice * soLuong;
                billTv.setText(String.valueOf(tongTien) + "đ");
            }
        });

        truBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soLuong > 1) {
                    soLuong--;
                    amountTv.setText(String.valueOf(soLuong));
                    tongTien = foodPrice * soLuong;
                    billTv.setText(String.valueOf(tongTien) + "đ");
//                    billTv.setText(String.valueOf(tongTien) + ".000đ");
                }
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] field = new String[3];
                field[0] = "foodID";
                field[1] = "customerID";
                field[2] = "number";

                String[] data = new String[3];
                data[0] = String.valueOf(foodID);
                SharedPreferences sp1 = getSharedPreferences("Login", MODE_PRIVATE);
                data[1] = String.valueOf(sp1.getInt("id", 0));
                data[2] = String.valueOf(soLuong);

                PutData putData = new PutData(Account.link + "addToCart.php", "POST", field, data);

                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        if(result.contains("Add to cart Success")){
                            Toast.makeText(Main_second.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        gioHangImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CheckOut.class);
                startActivity(intent);
                finish();
            }
        });
    }


}