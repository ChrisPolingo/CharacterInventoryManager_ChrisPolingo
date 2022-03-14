package com.example.characterinventorymanager_chrispolingo;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String itemName;
    public String itemDescription;

    public Item() {
        itemName = "";
        itemDescription = "";
    }

    public Item (String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return  itemDescription;
    }
}