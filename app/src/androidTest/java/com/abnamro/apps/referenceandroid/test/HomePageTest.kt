package com.abnamro.apps.referenceandroid.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abnamro.apps.referenceandroid.pages.HomePage
import com.abnamro.apps.referenceandroid.util.*
import com.abnamro.apps.referenceandroid.util.annotations.SmokeTest
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

//Junit runner to run tests
@RunWith(AndroidJUnit4::class)
class HomePageTest : BaseTest() {

    @Test
    fun toolBarIsDisplayed() {
        HomePage.toolBar().isDisplayed()
    }

    @Test
    fun toolBarTextIsDisplayed() {
        HomePage.toolBarTitle().isDisplayed()
    }

    @Test
    fun toolbarHasText() {
        val expected = HomePage.Data.TOOLBAR_TEXT
        HomePage.toolBar().hasText(expected)
    }

    @Test
    fun overflowMenuButtonTextIsDisplayed() {
        HomePage.overFlowMenuButton().isDisplayed()
    }

    @Test
    fun verifySettingsButtonText() {
        HomePage.clickOverFlowMenuButton()
        HomePage.settingsMenu().isDisplayedTimeout()
    }

    @Test
    @SmokeTest
    fun emailButtonIsDisplayed() {
        HomePage.emailButtonId().isDisplayed()
    }

    @Test
    fun emailButtonIsClickable() {
        HomePage.emailButtonId().isClickable()
    }


    @Test
    @SmokeTest
    fun snackBarTextIsDisplayed() {
        HomePage.emailButtonId().isClickable()
        HomePage.emailButtonId().clickOnElement()
        HomePage.snackBarText().isDisplayedTimeout()
    }

    @Test
    fun snackBarIsNotDisplayed() {
        HomePage.snackBarText().doesNotExistInView()
    }

    @Test
    fun mainScreenTextIsDisplayed() {
        HomePage.mainScreenText().isDisplayed()
    }
}