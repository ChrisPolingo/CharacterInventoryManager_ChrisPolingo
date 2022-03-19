package com.example.characterinventorymanager_chrispolingo;

import android.annotation.SuppressLint;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private Application application;
    private MainViewModel mainViewModel;

    public ItemAdapter(Application application, MainViewModel mainViewModel) {
        this.application = application;
        this.mainViewModel = mainViewModel;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Item item = mainViewModel.getSpecificItem(position);
        holder.tvName.setText(item.getItemName());
        holder.tvDescription.setText(item.getItemDescription());

        holder.btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainViewModel.remove(mainViewModel.getSpecificItem(position));
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainViewModel.getItemsSize();
    }


}
