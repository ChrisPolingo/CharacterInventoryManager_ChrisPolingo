package com.example.characterinventorymanager_chrispolingo;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private ItemDao itemDao;
    private List<Item> allItems;

    ItemRepository(Application application) {
        ItemDatabase db = ItemDatabase.getDatabase(application);
        itemDao = db.itemDao();
        allItems = new ArrayList<Item>();
    }

    List<Item> getAllItems() {
        ItemDatabase.databaseWriteExecutor.execute(() -> {
            allItems = itemDao.getAll();
        });
        return allItems;
    }

    void insert(Item item) {
        ItemDatabase.databaseWriteExecutor.execute(() -> {
            itemDao.insert(item);
        });
    }

    public Item getSpecificItem(Integer position) {
        Item currentItem = allItems.get(position);
        Log.d("Position equals ", String.valueOf(position));
        return currentItem;
    }

    public Integer getItemsSize() {
        return allItems.size();
    }
}
