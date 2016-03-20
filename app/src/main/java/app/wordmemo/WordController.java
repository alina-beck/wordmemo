package app.wordmemo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WordController {

    List<Word> wordList;
    MockData mockData = new MockData();

    public WordController () {
        this.wordList = mockData.getData();
    }

    public List<Word> getAllWords () {
        return this.wordList;
    }

    public List<Word> getDueWords () {
        List<Word> dueWords = new ArrayList<>();
        Calendar today = Calendar.getInstance();
        int compareVal;

        for (Word word : this.wordList) {
            compareVal = today.compareTo(word.getDueDate());

            if (compareVal >= 0) { // word.dueDate is today or before today -> word is due
                dueWords.add(word);
            }
        }
        return dueWords;
    }
}
