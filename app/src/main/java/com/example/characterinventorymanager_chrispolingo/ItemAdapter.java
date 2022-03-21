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

    /**
     * Constructor for the ItemAdapter
     * @param application
     * @param mainViewModel
     */
    public ItemAdapter(Application application, MainViewModel mainViewModel) {
        this.application = application;
        this.mainViewModel = mainViewModel;
    }

    /**
     * The required onCreateViewHolder method for an adapter
     * @param parent
     * @param viewType
     * @return new ItemViewHolder(view)
     */
    @NonNull
    @Override
     public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ItemViewHolder(view);
    }

    /**
     * The required onBindViewHolder method for an adapter
     * This sets the text in the item_recycler to the current data in the database.
     * This also starts the listener for the remove buttons for each item in the database.
     * @param holder
     * @param position
     */
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

    /**
     * getItemCount()
     * Calls and returns the getItemsSize() from the mainViewModel, getting the amount of items in the database.
     * @return mainViewModel.getItemSize()
     */
    @Override
    public int getItemCount() {
        return mainViewModel.getItemsSize();
    }


}
