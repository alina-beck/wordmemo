package app.wordmemo;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class MockDataTest {

    List<Word> data;

    @Before
    public void setUp () {
        MockData m = new MockData();

        this.data = m.getData();
    }

    @Test
    public void mockData_does_exist () throws Exception {
        assertEquals(data.isEmpty(), false);
    }

    @Test
    public void mockData_contains_valid_Words () throws Exception {
        assertFalse(data.get(0).getOriginal().length() == 0);
        assertFalse(data.get(0).getTranslation().length() == 0);
    }
}