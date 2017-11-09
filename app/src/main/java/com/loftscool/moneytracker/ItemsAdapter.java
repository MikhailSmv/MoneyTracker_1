package com.loftscool.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> items = new ArrayList<>();

    public ItemsAdapter() {
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
        items.add(new Item("Молоко",35));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
    holder.price.setText(String.valueOf(items.get(position).getPrice()));
    holder.name.setText(items.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

     static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView price;

        public ItemViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
        }
    }
}
