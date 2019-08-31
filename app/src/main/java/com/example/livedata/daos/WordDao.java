package com.example.livedata.daos;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.livedata.entities.Word;

import java.util.List;

// Data Access Object of the Word Table and Entity
@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("DELETE FROM words")
    void deleteAll();

    @Query("SELECT * FROM words ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

}