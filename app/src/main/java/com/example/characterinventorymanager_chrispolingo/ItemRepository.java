package com.example.characterinventorymanager_chrispolingo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private ItemDao itemDao;
    private MutableLiveData<List<Item>> allItems;

    ItemRepository(Application application) {
        ItemDatabase db = ItemDatabase.getDatabase(application);
        itemDao = db.itemDao();
        allItems = new MutableLiveData<List<Item>>();
    }

    MutableLiveData<List<Item>> getAllItems() {
        ItemDatabase.databaseWriteExecutor.execute(() -> {
            allItems.postValue(itemDao.getAll());
        });
        return allItems;
    }

    void insert(Item item) {
        ItemDatabase.databaseWriteExecutor.execute(() -> {
            itemDao.insert(item);
        });
    }

    public Item getSpecificItem(Integer position) {
        Item currentItem = allItems.getValue().get(position);
        Log.d("Position equals ", String.valueOf(position));
        return currentItem;
    }

    public Integer getItemsSize() {
        return allItems.getValue().size();
    }

    void delete(Item item) {
        ItemDatabase.databaseWriteExecutor.execute(() -> {
           itemDao.delete(item);
        });
    }

}
