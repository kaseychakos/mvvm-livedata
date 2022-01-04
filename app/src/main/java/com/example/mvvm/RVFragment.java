package com.example.mvvm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RVFragment extends Fragment {
    private RecyclerView recyclerView;
    private WidgetCustomAdapter widgetCustomAdapter;
    private ArrayList<Widget> widgets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rv, container, false);
//        widgetCustomAdapter = new WidgetCustomAdapter(widgets);
//
//        recyclerView = view.findViewById(R.id.widgetRV);
//        recyclerView.setAdapter(widgetCustomAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
   //     return view;
    }

    private void initDataset() {
        widgets = new ArrayList<>();
        widgets.add(new Widget("Example", "1234"));
    }

}