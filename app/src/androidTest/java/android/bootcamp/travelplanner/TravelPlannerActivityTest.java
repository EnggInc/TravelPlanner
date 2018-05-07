package android.bootcamp.travelplanner;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

// Tests for MainActivity
public class TravelPlannerActivityTest {

    // Preferred JUnit 4 mechanism of specifying the activity to be launched before each test
    @org.junit.Rule
    public android.support.test.rule.ActivityTestRule<android.bootcamp.travelplanner.TravelPlannerActivity> activityTestRule =
            new android.support.test.rule.ActivityTestRule<>(android.bootcamp.travelplanner.TravelPlannerActivity.class);

    // Looks for an EditText with id = "R.id.etInput"
    // Types the text "Hello" into the EditText
    // Verifies the EditText has text "Hello"
    @org.junit.Test
    public void validateEditText() {
        onView(withId(R.id.distance)).perform(typeText("333"));
        onView(withId(R.id.velocity)).perform(typeText("10"));

        onView(withId(R.id.calculate)).perform(click());
        onView(withId(R.id.time)).check(matches(withText(("33"))));

        //.check(matches(withText("333")));
    }
}