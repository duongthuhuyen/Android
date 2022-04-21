package com.example.beanikaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.beanikaa.Adapter.FoodRecyclerAdapter;
import com.example.beanikaa.Adapter.ViewPagerAdapter;
import com.example.beanikaa.Model.Food;
import com.example.beanikaa.common.Account;

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
    private static final String BASE_URL = Account.link + "getFoodList.php";

    private EditText nameField;
    private ImageView searchBtn;

    public String fName;

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

        nameField = findViewById(R.id.searchEt);
        searchBtn = findViewById(R.id.searchBtn);
        fName = nameField.getText().toString();

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

//        Search
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                call API search
                searchAPI(fName);
            }
        });

//        Rice category
        Rice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                foods_list.clear();
                category_url = Account.link + "getRiceList.php";
                getFoods(category_url);
            }
        });

//        Noodles category
        Noodles_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                foods_list.clear();
                category_url = Account.link + "getListCategory/getNoodlesList.php";
                getFoods(category_url);
            }
        });

//        Fastfood category
        Fastfood_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                foods_list.clear();
                category_url = Account.link + "getListCategory/getFastfoodList.php";
                getFoods(category_url);
            }
        });

//        Drinks category
        Drinks_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                foods_list.clear();
                category_url = Account.link + "getListCategory/getDrinksList.php";
                getFoods(category_url);
            }
        });
    }

//    insert code searchAPI here
    private void searchAPI(String name) {
        RequestQueue requestQueue = Volley.newRequestQueue(MainMenu.this);
        String url = "http://192.168.0.100/androidapi/product/getProduct/0";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String thumbnel = jsonObject.getString("thumbnal");
                        String address = jsonObject.getString("address");
                        double star = jsonObject.getInt("vote");
                        double price = jsonObject.getDouble("price");
                        System.out.println(thumbnel);
//                        homeItemModelArrayList.add(new HomeItemModel(thumbnel, address, star, Double.toString(price)));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //  Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("erro " + error.toString());
                Toast.makeText(MainMenu.this, "erro" + error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    private void getFoods(String category_url){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, category_url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i<=jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);

                        String id = object.getString("id");
                        String thumbnail = object.getString("img");
                        String foodname = object.getString("foodName");

                        double rating = object.getDouble("foodRating");
                        String str_rate = String.valueOf(rating);
                        float rate = Float.valueOf(str_rate);

                        int sales = object.getInt("sales");
                        double price = object.getDouble("price");
                        String address = object.getString("address");


                        Food aFood = new Food(id, thumbnail, foodname, sales, rate, price, address);

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