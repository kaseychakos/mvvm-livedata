package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.datEntryFragmentView, DataEntryFragment.class, null)
                    .add(R.id.rvFragmentView, RVFragment.class, null)
                    .commit();
        }
        setContentView(R.layout.activity_main);
    }
}