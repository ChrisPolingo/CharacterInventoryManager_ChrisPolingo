package com.example.characterinventorymanager_chrispolingo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Item")
    List<Item> getAll();

    @Insert
    void insert(Item item);

    @Delete
    void delete(Item item);

    @Query("DELETE FROM Item")
    void deleteAll();


    @Query("SELECT * FROM Item WHERE id = :Id")
    Item getByIds(int Id);

}