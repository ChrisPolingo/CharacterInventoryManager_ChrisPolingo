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

    public MainViewModel(@NonNull Application application) {
        super(application);
        itemRepository = new ItemRepository(application);

    }

    public void insert(String name, String description) {
        Item item = new Item(name, description);
        itemRepository.insert(item);

        mItemList = itemRepository.getAllItems();
        //itemList.add(item);
        //mItemList.postValue(itemList);
        Log.d("insert", name + "inserted into the itemRepository ");
    }

    public Integer getItemsSize() {
        return itemRepository.getItemsSize();
    }

    public Item getSpecificItem(Integer position) {
        return itemRepository.getSpecificItem(position);
    }

    public void remove(Item item) {
            itemRepository.delete(item);
            mItemList = itemRepository.getAllItems();
            //itemList = itemRepository.getAllItems();
    }
}
