package app.wordmemo;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class MockDataTest {

    @Test
    public void mockData_does_exist () throws Exception {
        MockData m = new MockData();

        List<Word> data = m.getData();

        assertEquals(data.isEmpty(), false);
    }

    @Test
    public void mockData_contains_valid_Words () throws Exception {
        MockData m = new MockData();

        List<Word> data = m.getData();

        assertFalse(data.get(0).getOriginal().length() == 0);
        assertFalse(data.get(0).getTranslation().length() == 0);
    }
}