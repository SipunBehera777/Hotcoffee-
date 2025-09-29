package com.example.hotcoffee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private List<CoffeeModel> coffeeList;
private OnDrinkClick drinkClick;
    public CoffeeAdapter(List<CoffeeModel> coffeeList,OnDrinkClick drinkClick) {
        this.coffeeList = coffeeList;
        this.drinkClick=drinkClick  ;  }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coffee_list, parent, false);
        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        CoffeeModel model = coffeeList.get(position);
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDescription());
        Glide.with(holder.itemView.getContext()).load(model.getImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drinkClick != null) {
                    drinkClick.onDrinkClick(model);
                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return coffeeList != null ? coffeeList.size() : 0;
    }

    public void setData(List<CoffeeModel> newData) {
        this.coffeeList = newData;
        notifyDataSetChanged();
    }

    static class CoffeeViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        ImageView imageView;
        CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.co_name);
            desc = itemView.findViewById(R.id.description);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
