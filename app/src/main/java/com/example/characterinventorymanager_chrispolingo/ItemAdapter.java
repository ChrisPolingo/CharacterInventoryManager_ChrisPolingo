package com.example.characterinventorymanager_chrispolingo;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private Application application;

    public ItemAdapter(Application application) {
    }



    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.tvName.setText("Sword");
        holder.tvDescription.setText("1d8 + 5 Slashing");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
