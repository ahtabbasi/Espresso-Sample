package com.abnamro.apps.referenceandroid.util

import androidx.test.espresso.ViewInteraction
import java.lang.Thread.sleep

object EspressoUtils {

    /*
     *  Repeatedly checks for view until found else throws exception.
     *  Allows custom timeout or default timeout
     *
     *  @param onView - view that needs to be searched
     *  @param timeout - Max time to wait for view/ default = 3000/3s.
     *  @param waitMillisPerTry - wait in milli seconds per try.
     *
     *  @return ViewInteraction - returns the view.
     */
    fun isDisplayedTimeout(
        onView: ViewInteraction,
        timeout: Int = 3000,
        waitMillisPerTry: Long = 100
    ): ViewInteraction {

        // Derive the max tries
        val maxTries = timeout / waitMillisPerTry.toInt()

        for (tries in 0..maxTries) {
            try {
                // check if view is displayed
                onView.isDisplayed()

                // If we're here, we found our view. Now return it
                return onView

            } catch (e: Exception) {
                val triesDone = tries + 1
                if (triesDone == maxTries) {
                    throw e
                }
                sleep(waitMillisPerTry)
            }
        }

        throw Exception("A matching view is not displayed")
    }
}