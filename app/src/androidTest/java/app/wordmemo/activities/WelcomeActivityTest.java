package app.wordmemo.activities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import app.wordmemo.R;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class WelcomeActivityTest {

    @Rule
    public ActivityTestRule<WelcomeActivity> activityTestRule =
            new ActivityTestRule<>(WelcomeActivity.class);

    @Test
    public void it_should_navigate_to_practice () {
        onView(withId(R.id.button_start_practice)).perform(click());
        withId(R.id.container_practice);
    }

    @Test
    public void it_should_navigate_to_add_words () {
        onView(withId(R.id.button_start_add_words)).perform(click());
        withId(R.id.container_add_word);
    }
}
