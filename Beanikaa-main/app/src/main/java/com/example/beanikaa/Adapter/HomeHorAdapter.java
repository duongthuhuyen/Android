package com.example.beanikaa.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beanikaa.Model.HomeHorModel;
import com.example.beanikaa.Model.HomeItemModel;
import com.example.beanikaa.R;

import java.util.ArrayList;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeHorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horitorier,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHorAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView.setText(list.get(position).getText());
        if(check){
            ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
         //   ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
            homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));

            homeItemModelArrayList.add(new HomeItemModel(R.drawable.rice,"Quang trung, Hà Nội", 4.5,"+111"));

            homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));

            homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));


           // homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội",4.5,"+111"));

            updateVerticalRec.callback(position,homeItemModelArrayList);
            check = false;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();
                if(position ==0){
                    ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.rice,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));


                    updateVerticalRec.callback(position,homeItemModelArrayList);
                }else if(position == 1){
                    ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.noodles,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));


                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội",4.5,"+111"));
                    updateVerticalRec.callback(position,homeItemModelArrayList);
                }else if(position == 2){
                    ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.fastfood,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));


                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội",4.5,"+111"));
                    updateVerticalRec.callback(position,homeItemModelArrayList);
                }else if(position == 3){
                    ArrayList<HomeItemModel> homeItemModelArrayList = new ArrayList<>();
                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.drinks,"Quang trung, Hà Nội", 4.5,"+111"));

                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội", 4.5,"+111"));


                    homeItemModelArrayList.add(new HomeItemModel(R.drawable.pizza,"Quang trung, Hà Nội",4.5,"+111"));

                    updateVerticalRec.callback(position,homeItemModelArrayList);
                }
            }
        });
      /*  if(select){
            if(position==0){
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
                select = false;
            }
        }else {
            if(row_index == position){
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
            }else {
                holder.cardView.setBackgroundResource(R.drawable.default_bg);
            }
        }*/
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            textView = itemView.findViewById(R.id.hor_txt);
            cardView = itemView.findViewById(R.id.cardviewHor);
        }
    }

}
