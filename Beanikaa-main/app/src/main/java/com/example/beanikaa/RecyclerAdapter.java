package com.example.beanikaa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Orders> ordersList = new ArrayList<>();


    public RecyclerAdapter (Context context,List<Orders> products){
        this.mContext = context;
        this.ordersList = products;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mName, mPrice, mAmount;
        private ImageView mImageView;
        private RatingBar mRate;
        private LinearLayout mContainer;

        public MyViewHolder (View view){
            super(view);

            mName = view.findViewById(R.id.product_title);
            mImageView = view.findViewById(R.id.product_image);
            mRate = view.findViewById(R.id.product_rating);
            mPrice = view.findViewById(R.id.product_price);
            mAmount = view.findViewById(R.id.product_amounts);
            mContainer = view.findViewById(R.id.product_container);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.products_list_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Orders product = ordersList.get(position);

        holder.mPrice.setText("Price: "+product.getPrice()+" vnd");
        holder.mAmount.setText("Amounts: "+product.getAmount());
        holder.mRate.setRating(product.getRating());
        holder.mName.setText(product.getName());
        Glide.with(mContext).load(product.getThumbnail()).into(holder.mImageView);

        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DetailedProductsActivity.class);

                intent.putExtra("name",product.getName());
                intent.putExtra("image",product.getThumbnail());
                intent.putExtra("rate",product.getRating());
                intent.putExtra("amount", product.getAmount());
                intent.putExtra("price",product.getPrice());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }
}
