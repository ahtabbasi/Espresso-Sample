package com.abnamro.apps.referenceandroid.util

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers

/* This class contains Kotlin extensions to make viewActions and viewAssertions
 * to be re-usable among different pages
 */

fun ViewInteraction.clickOnElement(): ViewInteraction {
    return perform(ViewActions.click())
}

fun ViewInteraction.isDisplayed(): ViewInteraction {
    return check(matches(ViewMatchers.isDisplayed()))
}

/* sending current view to Espresso util 'isDisplayedTimeout' to implicitly
 * wait for view to get visible
 */
fun ViewInteraction.isDisplayedTimeout(): ViewInteraction {
    return EspressoUtils.isDisplayedTimeout(this)
}

fun ViewInteraction.isClickable(): ViewInteraction {
    return check(matches(ViewMatchers.isClickable()))
}

fun ViewInteraction.hasText(text: String): ViewInteraction {
    return check(matches(ViewMatchers.withText(text)))
}

fun ViewInteraction.doesNotExistInView(): ViewInteraction {
    return check(doesNotExist())
}