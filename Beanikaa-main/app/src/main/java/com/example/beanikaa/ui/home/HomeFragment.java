package com.example.beanikaa.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beanikaa.Adapter.HomeHorAdapter;
import com.example.beanikaa.Adapter.HomeItemAdapter;
import com.example.beanikaa.Adapter.HomeSlideAdapter;
import com.example.beanikaa.Adapter.UpdateVerticalRec;
import com.example.beanikaa.Model.HomeHorModel;
import com.example.beanikaa.Model.HomeItemModel;
import com.example.beanikaa.Model.HomeSlideModel;
import com.example.beanikaa.R;
import com.example.beanikaa.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements UpdateVerticalRec {
    RecyclerView hoRecyclerView, homeVerRecyclerView;
    ArrayList<HomeHorModel> list;
    HomeHorAdapter homeHorAdapter;
    private FragmentHomeBinding binding;

    ArrayList<HomeItemModel> homeItemModelList;
    HomeItemAdapter homeItemAdapter;

   /* RecyclerView slideMealRec;
    HomeSlideAdapter slideMealAdapter;
    List<HomeSlideModel> slideMealModelList;*/

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        hoRecyclerView = root.findViewById(R.id.home_hor_rec);
        homeVerRecyclerView = root.findViewById(R.id.home_hor_item);
        list = new ArrayList<>();
        list.add(new HomeHorModel(R.drawable.drinks, "Drinks"));
        list.add(new HomeHorModel(R.drawable.fastfood, "Fastfood"));
        list.add(new HomeHorModel(R.drawable.noodles, "Noodle"));
        list.add(new HomeHorModel(R.drawable.rice, "Rice"));

        homeHorAdapter = new HomeHorAdapter(this, getActivity(), list);
        hoRecyclerView.setAdapter(homeHorAdapter);
        hoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        hoRecyclerView.setHasFixedSize(true);
        hoRecyclerView.setNestedScrollingEnabled(false);
        // home vertical
        homeItemModelList = new ArrayList<>();

        homeItemAdapter = new HomeItemAdapter(getActivity(), homeItemModelList);
        homeVerRecyclerView.setAdapter(homeItemAdapter);
        homeVerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        // homeVerRecyclerView.setHasFixedSize(true);
        //homeVerRecyclerView.setNestedScrollingEnabled(false);
/*        dailyMealRec = root.findViewById(R.id.daily_meal_rec);
        dailyMealModelList = new ArrayList<>();
        dailyMealModelList.add(new DailyMealModel(R.drawable.dinner,"Dinner","Sale 20%","Description","Description"));
        dailyMealModelList.add(new DailyMealModel(R.drawable.breakfast,"Breakfast","Sale 20%","Description","Description"));
        dailyMealModelList.add(new DailyMealModel(R.drawable.lunch,"Lunch","Sale 20%","Description","Description"));
        dailyMealModelList.add(new DailyMealModel(R.drawable.annhe,"Eat Easy","Sale 20%","Description","Description"));

        dailyMealAdapter = new DailyMealAdapter(dailyMealModelList,getContext());
        dailyMealRec.setAdapter(dailyMealAdapter);
        dailyMealRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        dailyMealRec.setHasFixedSize(true);
        dailyMealRec.setNestedScrollingEnabled(false);
        return root;*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callback(int position, ArrayList<HomeItemModel> list) {
        homeItemAdapter = new HomeItemAdapter(getContext(), list);
        homeItemAdapter.notifyDataSetChanged();
        homeVerRecyclerView.setAdapter(homeItemAdapter);

    }
}