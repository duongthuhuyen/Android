package com.example.beanikaa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beanikaa.Adapter.CheckOutRecyclerAdapter;
import com.example.beanikaa.Adapter.RecyclerAdapter;
import com.example.beanikaa.Model.CheckOutItem;
import com.example.beanikaa.Model.Orders;
import com.example.beanikaa.common.Account;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CheckOut extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter mAdapter;
    private List<CheckOutItem> ordersList;
    private static final String BASE_URL = Account.link + "getCart.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);

        recyclerView = findViewById(R.id.checkout_recyclerView);
        manager = new GridLayoutManager(CheckOut.this, 1);
        recyclerView.setLayoutManager(manager);
        ordersList = new ArrayList<>();

        String[] field = new String[1];
        field[0] = "userID";

        String[] data = new String[1];
        SharedPreferences sp1 = this.getSharedPreferences("Login", MODE_PRIVATE);
        data[0] = String.valueOf(sp1.getInt("id", 0));

        PutData putData = new PutData(BASE_URL, "POST", field, data);
        if (putData.startPut()) {
            if (putData.onComplete()) {
                String result = putData.getResult();

                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);

                        int idFood = object.getInt("idFoodNew");
                        int idOrder = object.getInt("idOrder");
                        String name = object.getString("foodName");
                        double price = object.getDouble("price");
                        int amount = object.getInt("number");

                        CheckOutItem item = new CheckOutItem(idOrder, amount, idFood, name, price );
                        ordersList.add(item);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                mAdapter = new CheckOutRecyclerAdapter(CheckOut.this, ordersList);
                recyclerView.setAdapter(mAdapter);
            }
        }
    }
}