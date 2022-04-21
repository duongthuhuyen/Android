package com.example.beanikaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
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
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryTest extends AppCompatActivity {

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
        manager = new GridLayoutManager(OrderHistoryTest.this, 1);
        recyclerView.setLayoutManager(manager);
        ordersList = new ArrayList<>();

        String[] field = new String[1];
        field[0] = "id";

        String[] data = new String[1];
        SharedPreferences sp1 = this.getSharedPreferences("Login", MODE_PRIVATE);
        data[0] = String.valueOf(sp1.getInt("id", 9));

        PutData putData = new PutData(BASE_URL, "POST", field, data);
        if (putData.startPut()) {
            if (putData.onComplete()) {
                String result = putData.getResult();

                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(result);
                    for (int i = 0; i <= jsonArray.length(); i++) {
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                mAdapter = new RecyclerAdapter(OrderHistoryTest.this, ordersList);
                recyclerView.setAdapter(mAdapter);
            }
        }
    }
}