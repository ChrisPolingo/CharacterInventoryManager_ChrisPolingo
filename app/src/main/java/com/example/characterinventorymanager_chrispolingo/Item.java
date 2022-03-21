package com.example.characterinventorymanager_chrispolingo;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String itemName;
    public String itemDescription;

    /**
     * Blank constructor for the Item object.
     */
    public Item() {
        itemName = "";
        itemDescription = "";
    }

    /**
     * Constructor that assigns values to both the itemName and itemDescription.
     * @param itemName
     * @param itemDescription
     */
    public Item (String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    /**
     * getItemName()
     * This gets the item name from the object
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * getItemDescription()
     * This gets the items description from the object
     * @return
     */
    public String getItemDescription() {
        return  itemDescription;
    }
}
