package com.example.livedata.viewmodels;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.livedata.entities.Word;
import com.example.livedata.repositories.WordRepository;
import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    private LiveData<List<Word>> allWords;

    public WordViewModel(Application application) {
        super(application);
        wordRepository = new WordRepository(application);

    }

    public LiveData<List<Word>> getAllWords() { return allWords; }
    public void insert(Word word) { wordRepository.insert(word); }
}
