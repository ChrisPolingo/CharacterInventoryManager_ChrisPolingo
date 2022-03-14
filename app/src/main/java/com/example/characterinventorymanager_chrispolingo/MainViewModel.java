package com.example.characterinventorymanager_chrispolingo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private ItemRepository itemRepository;
    //private List<Item> itemList;

    private MutableLiveData<List<Item>> mItemList;
        public MutableLiveData<List<Item>> getItemList() {
            if (mItemList == null) {
                mItemList = new MutableLiveData<List<Item>>();
                mItemList.postValue(itemRepository.getAllItems());
            }
            return mItemList;
        }

    public MainViewModel(@NonNull Application application) {
        super(application);
        itemRepository = new ItemRepository(application);
        //This line seems to crash the app, TODO ask Gibons about this
        //changeFlag.postValue(false);
    }

    public void insert(String name, String description) {
        Item item = new Item(name, description);
        itemRepository.insert(item);
        mItemList.postValue(itemRepository.getAllItems());
    }

    public Integer getItemsSize() {
        return itemRepository.getItemsSize();
    }

    public Item getSpecificItem(Integer position) {
        return itemRepository.getSpecificItem(position);
    }
}
