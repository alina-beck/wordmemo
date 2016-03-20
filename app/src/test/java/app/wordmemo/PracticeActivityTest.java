package app.wordmemo;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PracticeActivityTest {
    List<Word> data;

    @Before
    public void setUp () {
        MockData m = new MockData();

        this.data = m.getData();
    }

}
