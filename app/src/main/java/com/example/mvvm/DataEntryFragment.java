package com.example.mvvm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.UUID;

public class DataEntryFragment extends Fragment {
    private PersonViewModel personViewModel;
    private TextInputLayout textField;
    private Button submitBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment and get UI elements
        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);
        textField = view.findViewById(R.id.textField);
        submitBtn = view.findViewById(R.id.submitBtn);

        // Instantiate personViewModel with provider requiring shared activity
        personViewModel = new ViewModelProvider(requireActivity()).get(PersonViewModel.class);

        // On button click update ViewModel, check for NPE
        submitBtn.setOnClickListener(v -> {
            try {
                String personName = textField.getEditText().getText().toString();
                if (!personName.trim().matches("")) personViewModel.addPerson(
                        new Person(textField.getEditText().getText().toString(), generateUUID()));
            } catch (NullPointerException ex) {
                Toast.makeText(this.getContext(), "Must enter a name", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    /**
     * Generates a Universally Unique Identifier.
     * @return String
     */
    private String generateUUID() {
        return UUID.randomUUID().toString();
    }
}