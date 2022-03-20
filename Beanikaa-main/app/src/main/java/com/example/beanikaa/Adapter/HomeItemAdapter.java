package com.example.beanikaa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beanikaa.Model.HomeItemModel;
import com.example.beanikaa.R;

import java.util.ArrayList;

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.ViewModel>{
    Context context;
    ArrayList<HomeItemModel> homeItemModelList;

    public HomeItemAdapter(Context context, ArrayList<HomeItemModel> homeItemModelList) {
        this.context = context;
        this.homeItemModelList = homeItemModelList;
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_native_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        holder.imageView.setImageResource(homeItemModelList.get(position).getImage());
        holder.addressText.setText(homeItemModelList.get(position).getAddresstxt());
        holder.star.setText(""+homeItemModelList.get(position).getStarttxt());
        holder.priceText.setText(homeItemModelList.get(position).getInf());
      //  holder.timing.setText(homeVerModelList.get(position).getTimig());
    }

    @Override
    public int getItemCount() {
        return homeItemModelList.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView star,addressText,priceText;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewfood);
            star = itemView.findViewById(R.id.startxt);
            addressText = itemView.findViewById(R.id.addresstxt);
            priceText = itemView.findViewById(R.id.pricetxt);
        }
    }
}
