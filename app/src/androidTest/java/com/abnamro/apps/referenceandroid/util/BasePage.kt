package com.abnamro.apps.referenceandroid.util

import android.view.View
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.ViewInteraction
import org.hamcrest.Matcher

open class BasePage {

    fun snackBarText(snackBarText: Matcher<View>): ViewInteraction {
        return onView(snackBarText)
    }

    fun toolBarTitle(tooBarTitle: Matcher<View>): ViewInteraction {
        return onView(tooBarTitle)
    }

    /** Open the options menu OR open the overflow menu, depending on whether
    the device has a hardware or software overflow menu button.
    Reference: https://developer.android.com/training/testing/espresso/recipes#matching-view-inside-action-bar */
    fun clickOverFlowMenuButton() {
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())
    }
}