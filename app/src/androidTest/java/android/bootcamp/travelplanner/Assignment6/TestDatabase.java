package android.bootcamp.travelplanner.Assignment6;

import java.util.List;

import android.bootcamp.travelplanner.TravelPlan;
import android.bootcamp.travelplanner.TravelPlanDao;
import android.bootcamp.travelplanner.TravelPlannerDatabase;



import android.arch.persistence.room.Room;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@org.junit.runner.RunWith(android.support.test.runner.AndroidJUnit4.class)
public class TestDatabase {
    private TravelPlanDao mUserDao;
    private TravelPlannerDatabase mDb;


    // Preferred JUnit 4 mechanism of specifying the activity to be launched before each test
    @org.junit.Rule
    public android.support.test.rule.ActivityTestRule<android.bootcamp.travelplanner.TravelPlannerActivity> activityTestRule =
            new android.support.test.rule.ActivityTestRule<>(android.bootcamp.travelplanner.TravelPlannerActivity.class);

   @org.junit.Before
    public void createDb(){
        android.content.Context context = android.support.test.InstrumentationRegistry.getTargetContext();
        android.support.test.InstrumentationRegistry.getTargetContext().deleteDatabase("travelplanner");

        mDb = Room.databaseBuilder(context, TravelPlannerDatabase.class,"travelplanner").allowMainThreadQueries().build();
        mUserDao = mDb.travelPlanDao();
    }

    @org.junit.After
    public void closeDb() throws java.io.IOException {
        mDb.close();
    }

    @org.junit.Test
    public void writeUserAndReadInList() {


        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.distance)).perform(typeText("333"));
        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.velocity)).perform(typeText("10"));

        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.calculate)).perform(click());
        onView(android.support.test.espresso.matcher.ViewMatchers.withId(android.bootcamp.travelplanner.R.id.time)).check(matches(withText(("33"))));
        //User user = TestUtil.createUser(3);

        //user.setName("george");
        //mUserDao.insertAll(user);
        List<android.bootcamp.travelplanner.TravelPlan> byName = mUserDao.getAll();

        assertThat(byName.get(0).getDistance(), equalTo(333));
        assertThat(byName.get(0).getVelocity(), equalTo(10));
        assertThat(byName.get(0).getTime(), equalTo(33));

    }
}
