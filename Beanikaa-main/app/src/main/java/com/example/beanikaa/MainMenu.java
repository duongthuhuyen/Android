package com.example.beanikaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.beanikaa.Adapter.FoodRecyclerAdapter;
import com.example.beanikaa.Adapter.ViewPagerAdapter;
import com.example.beanikaa.Model.Food;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter mAdapter;
    private List<Food> foods_list;
    private static final String BASE_URL = "http://192.168.188.243/Beanikaa/getFoodList.php";

    ImageButton Rice_btn, Noodles_btn, Fastfood_btn, Drinks_btn;
    String category_url;

//    Banner
    ViewPager mViewPager;
    int[] images = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};

    ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Rice_btn = findViewById(R.id.rice_category);
        Noodles_btn = findViewById(R.id.noodles_category);
        Fastfood_btn = findViewById(R.id.fastfood_category);
        Drinks_btn = findViewById(R.id.drinks_category);

        recyclerView = findViewById(R.id.food_recyclerView);
        manager = new LinearLayoutManager(MainMenu.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        foods_list = new ArrayList<>();

        //load banner
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        mViewPagerAdapter = new ViewPagerAdapter(MainMenu.this, images);
        mViewPager.setAdapter(mViewPagerAdapter);

        getFoods(BASE_URL);

//        Rice category
        Rice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                foods_list.clear();
                category_url = "http://192.168.188.243/Beanikaa/getListCategory/getRiceList.php";
                getFoods(category_url);
            }
        });

//        Noodles category
        Noodles_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                foods_list.clear();
                category_url = "http://192.168.188.243/Beanikaa/getListCategory/getNoodlesList.php";
                getFoods(category_url);
            }
        });

//        Fastfood category
        Fastfood_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                foods_list.clear();
                category_url = "http://192.168.188.243/Beanikaa/getListCategory/getFastfoodList.php";
                getFoods(category_url);
            }
        });

//        Drinks category
        Drinks_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                foods_list.clear();
                category_url = "http://192.168.188.243/Beanikaa/getListCategory/getDrinksList.php";
                getFoods(category_url);
            }
        });
    }


    private void getFoods(String category_url){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, category_url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i<=jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);

                        String thumbnail = object.getString("img");
                        String foodname = object.getString("foodName");

                        double rating = object.getDouble("foodRating");
                        String str_rate = String.valueOf(rating);
                        float rate = Float.valueOf(str_rate);

                        int sales = object.getInt("sales");
                        int price = object.getInt("price");
                        String address = object.getString("address");


                        Food aFood = new Food(thumbnail, foodname, sales, rate, price, address);

                        foods_list.add(aFood);
                    }
                } catch (JSONException e) {}

                mAdapter = new FoodRecyclerAdapter(MainMenu.this, foods_list);
                recyclerView.setAdapter(mAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainMenu.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(MainMenu.this).add(stringRequest);

    }

}