package com.example.mvvm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RVFragment extends Fragment {
    private PersonViewModel personViewModel;
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

        // Setup recyclerView with LinearLayoutManager
        recyclerView = view.findViewById(R.id.widgetRV);
        recyclerView.setAdapter(personCustomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // View model setup and observer
        personViewModel = new ViewModelProvider(requireActivity()).get(PersonViewModel.class);
        personViewModel.getPeople().observe(getViewLifecycleOwner(), people -> {
            this.people.clear();
            this.people.addAll(people);
            personCustomAdapter.notifyDataSetChanged();
        });
        return view;
    }

    /**
     * Initializes the dataset and could be used for async calls
     */
    private void initDataset() {
        people = new ArrayList<>();
    }
}