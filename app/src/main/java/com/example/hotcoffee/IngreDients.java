package com.example.hotcoffee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IngreDients extends RecyclerView.Adapter<IngreDients.InViewholder> {
    List<String> ingridients;
    public IngreDients(List<String> ingridients) {
        this.ingridients=ingridients;
    }

    @NonNull
    @Override

    public IngreDients.InViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingridients,parent,false);
        return new InViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngreDients.InViewholder holder, int position) {
        String item=ingridients.get(position);
        holder.textView.setText(item);

    }

    @Override
    public int getItemCount() {
        return ingridients!=null ? ingridients.size() : 0;
    }

    public class InViewholder extends RecyclerView.ViewHolder {
        TextView textView;
        public InViewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
