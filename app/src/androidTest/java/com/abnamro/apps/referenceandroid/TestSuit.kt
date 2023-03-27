package com.abnamro.apps.referenceandroid

import com.abnamro.apps.referenceandroid.test.HomePageTest
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
 // More classes can be added in test suit
 // Useful when we have to run selected classes locally
@SuiteClasses(HomePageTest::class)
@Ignore("This ignores it for the pipeline")
class TestSuit