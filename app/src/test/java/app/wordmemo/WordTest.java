package app.wordmemo;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class WordTest {
    List<Word> data;

    @Before
    public void setUp () {
        MockData m = new MockData();

        this.data = m.getData();
    }

    @Test
    public void id_should_get_auto_incremented () {
        int idWord1 = data.get(0).getId();
        int idWord2 = data.get(1).getId();
        int idWord3 = data.get(5).getId();

        assertTrue(idWord1 < idWord2);
        assertTrue(idWord2 < idWord3);
        assertTrue(idWord1 == idWord2 - 1);
    }
}
