package com.example.characterinventorymanager_chrispolingo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder{

    TextView tvName;
    TextView tvDescription;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvDescription = itemView.findViewById(R.id.tvDescription);
    }
}
