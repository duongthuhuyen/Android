package com.example.beanikaa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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

    Button makeorderBtn;
    EditText phoneNumber, note_field, address_field;
    TextView total_field;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);

        recyclerView = findViewById(R.id.checkout_recyclerView);
        manager = new GridLayoutManager(CheckOut.this, 1);
        recyclerView.setLayoutManager(manager);
        ordersList = new ArrayList<>();

        makeorderBtn = findViewById(R.id.makeorder_btn);
        phoneNumber = findViewById(R.id.phonenumber_field);
        note_field = findViewById(R.id.note_field);
        address_field = findViewById(R.id.address_field);
        total_field = findViewById(R.id.total_field);

        double total = 0;

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

                        total += item.a_total();
                        ordersList.add(item);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                total_field.setText(String.valueOf(total));
                mAdapter = new CheckOutRecyclerAdapter(CheckOut.this, ordersList);
                recyclerView.setAdapter(mAdapter);
            }
        }



        makeorderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = String.valueOf(note_field.getText());
                String phoneNum = String.valueOf(phoneNumber.getText());
                String address = String.valueOf(address_field.getText());

                String[] field = new String[ordersList.size()+4];
                field[0] = "number";

                String[] data = new String[ordersList.size()+4];
                data[0]= String.valueOf(ordersList.size());//list là mảng dữ liệu (đổ từ getCart về )
                int j = 1;
                for(int i =0;i<ordersList.size();i++){
                    field[j] = "id_"+i;
                    data[j] = String.valueOf(ordersList.get(i).getIdorder());// sửa lại hàm lấy foodID
                    j++;
                }
                field[j] ="note";
                data[j] = note;
                field[j+1]= "address";
                data[j+1] = address;
                field[j+2] = "telephone";
                data[j+2] = phoneNum;

                PutData putData = new PutData(Account.link + "order.php", "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        if(result.contains("Order Success")){
                            Toast.makeText(CheckOut.this, "Đặt hàng thành công!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}