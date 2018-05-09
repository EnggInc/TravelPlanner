package android.bootcamp.travelplanner.Assignment4;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
//import static android.content.Intent;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.Matchers.equalTo;


//import static com.example.android.testing.espresso.intents.AdvancedSample.ImageViewHasDrawableMatcher.hasDrawable;

// Tests for MainActivity
public class TestImage {

    // Preferred JUnit 4 mechanism of specifying the activity to be launched before each test
    @org.junit.Rule
    public android.support.test.espresso.intent.rule.IntentsTestRule<android.bootcamp.travelplanner.TravelPlannerActivity> activityTestRule =
            new android.support.test.espresso.intent.rule.IntentsTestRule <>(android.bootcamp.travelplanner.TravelPlannerActivity.class);

    // Looks for an EditText with id = "R.id.etInput"
    // Types the text "Hello" into the EditText
    // Verifies the EditText has text "Hello"
    @org.junit.Test
    public void validateCameraScenario() {

        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.captureImageButton)).perform(click());
        intended(allOf( hasAction(equalTo(android.provider.MediaStore.ACTION_IMAGE_CAPTURE))));

    }


}