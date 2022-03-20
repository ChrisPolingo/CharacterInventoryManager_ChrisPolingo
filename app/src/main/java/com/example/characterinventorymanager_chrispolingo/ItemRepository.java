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

    /**
     * insert(Item item)
     * Inserts the item into the itemDao, and updates allItems with the current items in the itemDao.
     * @param item
     */
    void insert(Item item) {
        ItemDatabase.databaseWriteExecutor.execute(() -> {
            itemDao.insert(item);
            allItems.postValue(itemDao.getAll());
        });
    }

    /**
     * getSpecificItem(Integer position)
     * Gets an item from the allItems list, using the position.
     * Returns an Item, returning the currentItem.
     * @param position
     * @return currentItem
     */
    public Item getSpecificItem(Integer position) {
        Item currentItem = allItems.getValue().get(position);
        Log.d("Position equals ", String.valueOf(position));
        return currentItem;
    }

    /**
     * getItemSize()
     * Returns the size of the allItems list
     * @return allItems.getValue().size()
     */
    public Integer getItemsSize() {
        return allItems.getValue().size();
    }

    /**
     * delete(Item item)
     * calls the itemDao to delete the 'item', then updates the allItems list with all the remaining items in the itemDao.
     * @param item
     */
    void delete(Item item) {
        ItemDatabase.databaseWriteExecutor.execute(() -> {
           itemDao.delete(item);
           allItems.postValue(itemDao.getAll());
        });
    }

}
