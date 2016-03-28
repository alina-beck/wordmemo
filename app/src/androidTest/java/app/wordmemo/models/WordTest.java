package app.wordmemo.models;

import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class WordTest {

    private Word word;

    @Before
    public void createTestWord () {
        word = new Word("Original", "Translation");
    }

    @Test
    public void word_implements_parcelable_correctly () {
        // write the data
        Parcel parcel = Parcel.obtain();
        word.writeToParcel(parcel, word.describeContents());

        // reset parcel for reading
        parcel.setDataPosition(0);

        // read the data
        Word createdFromParcel = Word.CREATOR.createFromParcel(parcel);

        // test
        assertEquals(word.getOriginal(), createdFromParcel.getOriginal());
        assertEquals(word.getTranslation(), createdFromParcel.getTranslation());
        assertEquals(word.getDueDate(), createdFromParcel.getDueDate());
        assertEquals(word.getId(), createdFromParcel.getId());
    }
}
