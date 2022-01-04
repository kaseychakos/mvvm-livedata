package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.color.DynamicColors;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PersonViewModel personViewModel;
    private RecyclerView peopleRecyclerView;
    private PersonCustomAdapter personCustomAdapter;
    private ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DynamicColors.applyToActivitiesIfAvailable(this.getApplication());
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.datEntryFragmentView, DataEntryFragment.class, null)
                    .add(R.id.rvFragmentView, RVFragment.class, null)
                    .commit();
        }
    }
}