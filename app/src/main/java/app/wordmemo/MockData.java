package app.wordmemo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.wordmemo.models.Word;

public class MockData {

    private List<Word> data;

    public MockData() {
        this.data = initializeMockData();
    }

    public List<Word> getData() {
        return data;
    }

    public List<Word> initializeMockData() {
        List<Word> newData = new ArrayList<>();

        newData.add(new Word("Hallo",  "Hej"));
        newData.add(new Word("Auto",   "bil"));
        newData.add(new Word("Haus",   "hus"));
        newData.add(new Word("Tisch",  "bord"));
        newData.add(new Word("sehen",  "se"));
        newData.add(new Word("ich",    "jag"));

        // adding some words that are due
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DATE, -3);

        newData.add(new Word("gestern", "igår", past));
        newData.add(new Word("Dienstag", "tisdag", past));

        return newData;
    }

}
