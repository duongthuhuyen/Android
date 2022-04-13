package com.example.beanikaa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailedProductsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private ImageView mImage;
    private TextView mTitle, mRating, mPrice, mAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_products);

        mToolbar = findViewById(R.id.toolbar);
        mImage = findViewById(R.id.image_view);
        mPrice = findViewById(R.id.price);
        mRating = findViewById(R.id.rating);
        mTitle = findViewById(R.id.name);
        mAmount = findViewById(R.id.amount);

        // Setting up action bar
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_chevron_left_black_24dp));

        // Catching incoming intent
        Intent intent = getIntent();
        double price = intent.getDoubleExtra("price", 0);
        float rate = intent.getFloatExtra("rate", 0);
        int amount = intent.getIntExtra("amount", 0);
        String title = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");

        if (intent != null) {

            mActionBar.setTitle(title);
            mTitle.setText(title);
            mRating.setText("Rating: " + rate + " /2");
            mPrice.setText(String.valueOf(price));
            mAmount.setText("Amount: " + amount);
            Glide.with(DetailedProductsActivity.this).load(image).into(mImage);
        }

    }
}