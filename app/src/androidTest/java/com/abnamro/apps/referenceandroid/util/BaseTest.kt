package com.abnamro.apps.referenceandroid.util

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.abnamro.apps.referenceandroid.MainActivity
import org.junit.Rule

open class BaseTest {
    /** Job of BaseTest is to start activity to test classes
     * Works in current scenario because of single activity in project
     * TODO: To pass activity from test classes using kotlin generics*/
    @get:Rule
    var activityRule = ActivityScenarioRule(
        MainActivity::class.java
    )
}
