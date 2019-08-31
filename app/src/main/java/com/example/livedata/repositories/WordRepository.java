package com.example.livedata.repositories;
import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.example.livedata.daos.WordDao;
import com.example.livedata.database.WordRoomDatabase;
import com.example.livedata.entities.Word;
import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }


    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }
}
