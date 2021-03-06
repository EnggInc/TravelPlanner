package android.bootcamp.travelplanner.Assignment5;


import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.Instrumentation.ActivityResult;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

//import static com.example.anuja.cameraintentsample.ImageViewMatcher.hasDrawable;
import static org.hamcrest.Matchers.not;




//hasDrawableImport
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;




// Tests for MainActivity
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestImageCapture {

    @Rule
    //public IntentsTestRule<ImageViewerActivity> mIntentsRule = new IntentsTestRule<>(
    //        ImageViewerActivity.class);
    public android.support.test.espresso.intent.rule.IntentsTestRule<android.bootcamp.travelplanner.TravelPlannerActivity> activityTestRule =
            new android.support.test.espresso.intent.rule.IntentsTestRule <>(android.bootcamp.travelplanner.TravelPlannerActivity.class);


    @Before
    public void stubCameraIntent() {
        ActivityResult result = createImageCaptureStub();

        // Stub the Intent.
        intending(hasAction(MediaStore.ACTION_IMAGE_CAPTURE)).respondWith(result);
    }

    @Test
    public void testTakePhoto() {
        // Check that the ImageView doesn't have a drawable applied.
        onView(withId(android.bootcamp.travelplanner.R.id.capturedImage)).check(matches(not(hasDrawable())));

        // Click on the button that will trigger the stubbed intent.
        onView(withId(android.bootcamp.travelplanner.R.id.captureImageButton)).perform(click());

        // With no user interaction, the ImageView will have a drawable.
        onView(withId(android.bootcamp.travelplanner.R.id.capturedImage)).check(matches(hasDrawable()));
    }

    private ActivityResult createImageCaptureStub() {
        // Put the drawable in a bundle.
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", BitmapFactory.decodeResource(
                activityTestRule.getActivity().getResources(), android.bootcamp.travelplanner.R.mipmap.ic_launcher));

        // Create the Intent that will include the bundle.
        Intent resultData = new Intent();
        resultData.putExtras(bundle);

        // Create the ActivityResult with the Intent.
        return new ActivityResult(Activity.RESULT_OK, resultData);
    }


    public static BoundedMatcher<View, ImageView> hasDrawable() {
        return new BoundedMatcher<View, ImageView>(ImageView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has drawable");
            }

            @Override
            public boolean matchesSafely(ImageView imageView) {
                return imageView.getDrawable() != null;
            }
        };
    }




}