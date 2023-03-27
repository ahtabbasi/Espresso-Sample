package com.abnamro.apps.referenceandroid.pages

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.*
import com.abnamro.apps.referenceandroid.R
import com.abnamro.apps.referenceandroid.util.BasePage
import org.hamcrest.Matcher
import org.hamcrest.Matchers as HamcrestMatchers

// ViewMatchers for Home Page
object HomePage : BasePage() {

    // Data object to help finding page view and verify home page ViewAssertions
    object Data {
        const val TOOLBAR_TEXT = "ReferenceAndroid"
        const val SETTINGS_MENU_TEXT = "Settings"
        const val MAIN_SCREEN_TEXT = "Hello World!"
        const val SNACK_BAR_TEXT = "Replace with your own action"
        const val OVERFLOW_MENU_TEXT = "More options"
    }
    // Holds matchers to locate elements at home page
    private object Matchers {
        private const val TOOLBAR_ID = R.id.toolbar
        private const val EMAIL_BUTTON_ID = R.id.fab

        val toolBar: Matcher<View> = withId(TOOLBAR_ID)
        val toolbarTitle: Matcher<View> = withText(Data.TOOLBAR_TEXT)
        val settingMenuText: Matcher<View> = withText(Data.SETTINGS_MENU_TEXT)
        val overflowMenuButtonText: Matcher<View> = withContentDescription(Data.OVERFLOW_MENU_TEXT)
        val floatingEmailButton: Matcher<View> = withId(EMAIL_BUTTON_ID)
        val snackBarText: Matcher<View> = withText(Data.SNACK_BAR_TEXT)
        val mainScreenText: Matcher<View> = withText(Data.MAIN_SCREEN_TEXT)
    }

    // Returns the ViewInteraction for toolbar on HomePage
    fun toolBar(): ViewInteraction {
        return onView(
            HamcrestMatchers.allOf(
                HamcrestMatchers.instanceOf(TextView::class.java),
                withParent(Matchers.toolBar)
            )
        )
    }

    fun toolBarTitle(): ViewInteraction {
        return toolBarTitle(Matchers.toolbarTitle)
    }

    fun emailButtonId(): ViewInteraction {
        return onView(Matchers.floatingEmailButton)
    }

    fun settingsMenu(): ViewInteraction {
        return onView(Matchers.settingMenuText)
    }

    fun snackBarText(): ViewInteraction {
        return snackBarText(Matchers.snackBarText)
    }

    fun mainScreenText(): ViewInteraction {
        return onView(Matchers.mainScreenText)
    }

    fun overFlowMenuButton(): ViewInteraction {
        return onView(Matchers.overflowMenuButtonText)
    }
}