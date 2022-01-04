package com.example.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonCustomAdapter extends RecyclerView.Adapter<PersonCustomAdapter.ViewHolder>{
    private ArrayList<Person> people;

    public PersonCustomAdapter(ArrayList<Person> people) {
        this.people = people;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView idView;
        public ViewHolder(@NonNull View view) {
            super(view);
            textView = view.findViewById(R.id.widgetNameTextView);
            idView = view.findViewById(R.id.widgetIdTextView);
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getIdView() {
            return idView;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(people.get(position).getName());
        holder.getIdView().setText(people.get(position).getID());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

}
