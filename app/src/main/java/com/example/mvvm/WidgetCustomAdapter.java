package com.example.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WidgetCustomAdapter extends RecyclerView.Adapter<WidgetCustomAdapter.ViewHolder>{
    private Widget[] widgets;

    public WidgetCustomAdapter(Widget[] widgets) {
        this.widgets = widgets;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView idView;
        public ViewHolder(@NonNull View view) {
            super(view);
            textView = view.findViewById(R.id.widgetIdTextView);
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
        holder.getTextView().setText(widgets[position].getName());
        holder.getIdView().setText(widgets[position].getID());
    }

    @Override
    public int getItemCount() {
        return widgets.length;
    }

}
