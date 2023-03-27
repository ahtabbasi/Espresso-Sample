package com.abnamro.apps.referenceandroid.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abnamro.apps.referenceandroid.pages.HomePage
import com.abnamro.apps.referenceandroid.util.*
import com.abnamro.apps.referenceandroid.util.annotations.SmokeTest
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

// Junit runner to run tests
// Getting activity from BaseTest
@RunWith(AndroidJUnit4::class)
class HomePageTest : BaseTest() {

    // Verifies toolbar is displayed
    @Test
    fun toolBarIsDisplayed() {
        HomePage.toolBar().isDisplayed()
    }

    // Verifies toolbar text is displayed
    @Test
    fun toolBarTextIsDisplayed() {
        HomePage.toolBarTitle().isDisplayed()
    }

    // Verifies toolbar text
    @Test
    fun toolbarHasText() {
        val expected = HomePage.Data.TOOLBAR_TEXT
        HomePage.toolBar().hasText(expected)
    }

    // Verify overflow menu is displayed
    @Test
    fun overflowMenuButtonTextIsDisplayed() {
        HomePage.overFlowMenuButton().isDisplayed()
    }

    // Verifies settings inside overflow menu button
    // isDisplayedTimeout to wait and retry for specific time until view is visible
    @Test
    fun verifySettingsButtonText() {
        HomePage.clickOverFlowMenuButton()
        HomePage.settingsMenu().isDisplayedTimeout()
    }

    // Verifies floating email icon is displayed
    @Test
    @SmokeTest
    fun emailButtonIsDisplayed() {
        HomePage.emailButtonId().isDisplayed()
    }

    // Verifies floating email icon is clickable
    @Test
    fun emailButtonIsClickable() {
        HomePage.emailButtonId().isClickable()
    }

    // Verifies snack-bar is displayed after clicking floating email button
    // isDisplayedTimeout to wait and retry for specific time until view is visible
    @Test
    @SmokeTest
    fun snackBarTextIsDisplayed() {
        HomePage.emailButtonId().isClickable()
        HomePage.emailButtonId().clickOnElement()
        HomePage.snackBarText().isDisplayedTimeout()
    }

    // Verifies snack-bar is not displayed
    @Test
    fun snackBarIsNotDisplayed() {
        HomePage.snackBarText().doesNotExistInView()
    }

    //Verifies text on home screen is displayed
    @Test
    fun mainScreenTextIsDisplayed() {
        HomePage.mainScreenText().isDisplayed()
    }
}