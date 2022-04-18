package com.example.beanikaa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.beanikaa.DetailedProductsActivity;
import com.example.beanikaa.Main_second;
import com.example.beanikaa.Model.Food;
import com.example.beanikaa.R;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.MyViewHolder>{
    private Context mContext;
    private List<Food> foodList = new ArrayList<>();

    public FoodRecyclerAdapter(Context context, List<Food> foodList){
        this.mContext = context;
        this.foodList = foodList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mName, mRate, mSales;
        private ImageView mThumbnail;
        private androidx.constraintlayout.widget.ConstraintLayout mContainer;

        public MyViewHolder (View view){
            super(view);

            mThumbnail = view.findViewById(R.id.aFood_thumbnail);
            mName = view.findViewById(R.id.aFood_name);
            mRate = view.findViewById(R.id.aFood_rate);
            mSales = view.findViewById(R.id.aFood_sales);
            mContainer = view.findViewById(R.id.aFood_container);
        }
    }

    @NonNull
    @Override
    public FoodRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.foods_list_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodRecyclerAdapter.MyViewHolder holder, int position) {
        final Food aFood = foodList.get(position);

        holder.mName.setText(aFood.getfoodname());
        holder.mRate.setText(""+aFood.getRating());
        holder.mSales.setText("("+aFood.getSales()+")");
        Glide.with(mContext).load(aFood.getThumbnail()).into(holder.mThumbnail);

        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Main_second.class);

                intent.putExtra("name", aFood.getfoodname());
                intent.putExtra("address", aFood.getAddress());
                intent.putExtra("rating", aFood.getRating());
                intent.putExtra("price", aFood.getPrice());

//                intent.putExtra("name",aFood.getfoodname());
//                intent.putExtra("image",aFood.getThumbnail());
//                intent.putExtra("rate",aFood.getRating());
//                intent.putExtra("amount", aFood.getSales());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
