package com.ayokunlepaul.channel

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule

@HiltAndroidTest
class MainActivityTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    fun testThatViewsAreShowing() {
        val scenario = scenario
    }
}