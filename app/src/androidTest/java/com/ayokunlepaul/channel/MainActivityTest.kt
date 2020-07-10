package com.ayokunlepaul.channel

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.ayokunlepaul.channel.presentation.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {

    }

    @Test
    fun testThatViewsAreShowing() {
        onView(withId(R.id.activity_new_episodes_title)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.categories_title)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
        onView(withId(R.id.activity_title)).check(
            matches(
                withEffectiveVisibility(
                    Visibility.VISIBLE
                )
            )
        )
    }
}