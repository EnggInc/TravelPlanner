package android.bootcamp.travelplanner.Assignment3;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

// Tests for MainActivity
public class TravelPlannerReverseBuffer {

    // Preferred JUnit 4 mechanism of specifying the activity to be launched before each test
    @org.junit.Rule
    public android.support.test.rule.ActivityTestRule<android.bootcamp.travelplanner.TravelPlannerActivity> activityTestRule =
            new android.support.test.rule.ActivityTestRule<>(android.bootcamp.travelplanner.TravelPlannerActivity.class);

    // Looks for an EditText with id = "R.id.etInput"
    // Types the text "Hello" into the EditText
    // Verifies the EditText has text "Hello"
    @org.junit.Test
    public void validateEditTextReverseBuffer() {
        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.distance)).perform(typeText("333"));
        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.velocity)).perform(typeText("10"));

        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.newTab)).perform(click());
        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.intentTime)).check(matches(withText(("33"))));
        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.buffer)).perform(typeText("22"));

        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.plusBuffer)).perform(click());
        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.time_with_buffer)).check(matches(withText(("Value with buffer = 55"))));

    }

}
