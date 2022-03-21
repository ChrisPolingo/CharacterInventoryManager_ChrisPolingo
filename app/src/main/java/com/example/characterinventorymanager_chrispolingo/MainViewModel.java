package com.example.characterinventorymanager_chrispolingo;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private ItemRepository itemRepository;
    //private List<Item> itemList;

    private MutableLiveData<List<Item>> mItemList;
        public MutableLiveData<List<Item>> setupItemList() {
            if (mItemList == null) {
                //mItemList = new MutableLiveData<List<Item>>();
                mItemList = itemRepository.getAllItems();
                //itemList = itemRepository.getAllItems();
            }
            return mItemList;
        }

        public MutableLiveData<List<Item>> getItemList() {
            return mItemList;
        }

    /**
     * Constructor for the MainViewModel
     * @param application
     */
    public MainViewModel(@NonNull Application application) {
        super(application);
        itemRepository = new ItemRepository(application);

    }

    /**
     * insert(String name, String description)
     * Puts the Name and Description and puts them into an Item object.
     * Then it inserts the item into the itemRepository, also updating the mItemList to match the itemRepository.
     * @param name
     * @param description
     */
    public void insert(String name, String description) {
        Item item = new Item(name, description);
        itemRepository.insert(item);

        mItemList = itemRepository.getAllItems();
        //itemList.add(item);
        //mItemList.postValue(itemList);
        Log.d("insert", name + "inserted into the itemRepository ");
    }

    /**
     * getItemsSize()
     * Gets and returns the size of the item list from the repository.
     * @return itemRepository.getItemsSize()
     */
    public Integer getItemsSize() {
        return itemRepository.getItemsSize();
    }

    /**
     * getSpecificItem(Integer position)
     * Gets one item from the itemRepository, using the position
     * @param position
     * @return itemRepository.getSpecificItem(position)
     */
    public Item getSpecificItem(Integer position) {
        return itemRepository.getSpecificItem(position);
    }


    /**
     * remove(Item item)
     * Calls the delete method in the itemRepository and updates the mItemList to the state of the itemRepository.
     * @param item
     */
    public void remove(Item item) {
            itemRepository.delete(item);
            mItemList = itemRepository.getAllItems();
            //itemList = itemRepository.getAllItems();
    }
}
