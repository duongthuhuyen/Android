package com.example.beanikaa.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beanikaa.Adapter.HomeSlideAdapter;
import com.example.beanikaa.Model.HomeSlideModel;
import com.example.beanikaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class SlideFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

    RecyclerView slideMealRec;
    HomeSlideAdapter slideMealAdapter;
    List<HomeSlideModel> slideMealModelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        //retu
        View root = inflater.inflate(R.layout.fragment_slide,container,false);
        slideMealRec = root.findViewById(R.id.home_hor_slide);
        slideMealModelList = new ArrayList<>();
        slideMealModelList.add(new HomeSlideModel(R.drawable.pizza));
        slideMealModelList.add(new HomeSlideModel(R.drawable.pizza));
        slideMealModelList.add(new HomeSlideModel(R.drawable.pizza));
        slideMealModelList.add(new HomeSlideModel(R.drawable.pizza));

        slideMealAdapter = new HomeSlideAdapter(slideMealModelList,getContext());
        slideMealRec.setAdapter(slideMealAdapter);
        slideMealRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        slideMealRec.setHasFixedSize(true);
        slideMealRec.setNestedScrollingEnabled(false);

        return root;
    }
}