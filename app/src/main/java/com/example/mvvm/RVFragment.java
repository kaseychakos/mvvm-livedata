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
    private PersonCustomAdapter personCustomAdapter;
    private ArrayList<Person> people;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rv, container, false);
        personCustomAdapter = new PersonCustomAdapter(people);

        recyclerView = view.findViewById(R.id.widgetRV);
        recyclerView.setAdapter(personCustomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    private void initDataset() {
        people = new ArrayList<>();
        people.add(new Person("Example", "1234"));
    }

}