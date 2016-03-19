package app.wordmemo;

import org.junit.Before;
import java.util.List;

public class WordTest {
    List<Word> data;

    @Before
    public void setUp () {
        MockData m = new MockData();

        this.data = m.getData();
    }
}
