package app.wordmemo;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.*;

public class WordControllerTest {

    WordController wordController = new WordController();

    @Test
    public void it_should_deliver_a_list_of_all_words () {
        List<Word> wordList = wordController.getAllWords();

        assertTrue(wordList.size() > 0);
    }

    @Test
    public void it_should_deliver_a_list_of_due_words () {
        List<Word> wordList = wordController.getAllWords();
        List<Word> dueList = wordController.getDueWords();

        assertTrue(wordList.size() > dueList.size());

        Calendar today = Calendar.getInstance();

        for (Word word : dueList) {
            assertTrue(today.compareTo(word.getDueDate()) <= 0); // today or before today
        }
    }
}
