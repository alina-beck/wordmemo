package app.wordmemo;

import java.util.ArrayList;
import java.util.List;

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

        return newData;
    }

}
