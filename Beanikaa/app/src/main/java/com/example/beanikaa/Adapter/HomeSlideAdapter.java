package com.example.beanikaa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beanikaa.Model.HomeSlideModel;
import com.example.beanikaa.R;

import java.util.List;

public class HomeSlideAdapter extends RecyclerView.Adapter<HomeSlideAdapter.ViewModel>{
    List<HomeSlideModel> list;
    Context context;

    public HomeSlideAdapter(List<HomeSlideModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_horitorier,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        ImageView image;
       // TextView name,discount,descript;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hor_slide);


        }
    }
}
