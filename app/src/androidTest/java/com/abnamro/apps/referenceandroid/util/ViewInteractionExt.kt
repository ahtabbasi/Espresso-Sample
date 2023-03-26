package com.abnamro.apps.referenceandroid.util

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers


fun ViewInteraction.clickOnElement(): ViewInteraction {
    return perform(ViewActions.click())
}

fun ViewInteraction.isDisplayed(): ViewInteraction {
    return check(matches(ViewMatchers.isDisplayed()))
}

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