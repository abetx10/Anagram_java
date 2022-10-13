package com.example.anagram_java;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityEspressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void reverseTextIsDisplayedInAnagramTv() {
        onView(withId(R.id.et_text)).perform(ViewActions.typeText("Foxminded cool 24/7"));
        onView(withId(R.id.et_filter)).perform(ViewActions.typeText("xl"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.bt_convert)).perform(click());
        onView(withId(R.id.tv_anagram)).check(matches(withText("dexdnimoF oocl 7/42")));
    }

    @Test
    public void reverseTextIsDisplayedInAnagramTvWithoutFilter() {
        onView(withId(R.id.et_text)).perform(ViewActions.typeText("Foxminded cool 24/7"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.bt_convert)).perform(click());
        onView(withId(R.id.tv_anagram)).check(matches(withText("dednimxoF looc 24/7")));
    }

    @Test
    public void emptyFieldInTextEt() {
        onView(withId(R.id.et_text)).perform(ViewActions.typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.bt_convert)).perform(click());
        onView(withId(R.id.tv_anagram)).check(matches(withText("Here must be your anagram")));
    }

    @Test
    public void IsFewLinesInTextEt() {
        onView(withId(R.id.et_text)).perform(ViewActions.typeText("Foxminded"),
        pressImeActionButton());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.bt_convert)).perform(click());
        onView(withId(R.id.tv_anagram)).check(matches(withText("dednimxoF")));
    }
}