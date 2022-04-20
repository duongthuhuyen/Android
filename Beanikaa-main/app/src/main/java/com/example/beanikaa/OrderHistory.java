package com.example.beanikaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.beanikaa.Adapter.RecyclerAdapter;
import com.example.beanikaa.Model.Orders;
import com.example.beanikaa.common.Account;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter mAdapter;
    private List<Orders> ordersList;
    private static final String BASE_URL =  Account.link + "OrderHistory.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        recyclerView = findViewById(R.id.products_recyclerView);
        manager = new GridLayoutManager(OrderHistory.this, 1);
        recyclerView.setLayoutManager(manager);
        ordersList = new ArrayList<>();

        getOrders();
    }

    private void getOrders() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i=0; i<=jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);

                        String thumbnail = object.getString("img");
                        String name = object.getString("name");
                        double price = object.getDouble("price");
                        int amount = object.getInt("amount");
                        double rating = object.getDouble("rating");
                        String str_rate = String.valueOf(rating);
                        float rate = Float.valueOf(str_rate);

                        Orders order = new Orders(thumbnail, name, price, amount, rate);

                        ordersList.add(order);
                    }
                }catch (Exception e){

                }

                mAdapter = new RecyclerAdapter(OrderHistory.this, ordersList);
                recyclerView.setAdapter(mAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(OrderHistory.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(OrderHistory.this).add(stringRequest);

    }
}