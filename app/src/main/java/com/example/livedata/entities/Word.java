package com.example.livedata.entities;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Table
@Entity(tableName = "words")
public class Word {

    // Column
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String word;

    // Constructor
    public Word(@NonNull String word) {
        this.word = word;
    }

    // Get and Set
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
}