
This project is a demonstration of instrument tests for UI testing of an Android application. The tests are implemented using Espresso with Kotlin. 
 I learned both Kotlin and [Espresso](https://developer.android.com/training/testing/espresso/recipes#matching-view-inside-action-bar) while implementing this project for the first time.
 
## Applied Pattern
I have used the Page Object Model pattern to segregate test code from page-specific code. Robot Pattern and POM pattern were also considered. Both of them are almost alike; in the end, both are used to write `WHAT` in the tests, not `HOW`.

POM  | 
------------- | 
![POM-Diagram](/page-object-model.png)


## Framework Overview

The following is an overview of the project's package structure:

Project Overview  | 
------------- | 
![Project-Overview-Diagram](/project-overview.png)

- `referenceandroid`: Package that includes instrument tests
- `pages`: `HomePage` class that includes Matchers for Home page
- `test`: `HomePageTest` class that includes Home page assertions
- `utils`: `annotations` package includes `SmokeTest` class that includes annotation to group test cases
- `utils`: `BasePage` class includes reusable methods for all pages
- `utils`: `BaseTest` class is a class that contains common code for test classes
- `utils`: `EspressoUtils` is a helper utility for Espresso
- `utils`: `ViewInteractionsExt` includes Kotlin extensions for view interactions

## Test Scenarios

The following test scenarios are covered in this project:

- Verify the Toolbar
- Verify the Home Screen
- Verify the Overflow Menu Section
- Verify the SnackBar and Email button

## Test Execution

There are several ways to execute the tests:

1. Tests can be run from `TestSuit` class. (Remove `@ignore` annotation)
2. From the command line:
   - To run all UI tests: `./gradlew connectedAndroidTest`
   - To run `@SmokeTest` annotated tests: `./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.annotation=com.abnamro.apps.referenceandroid.util.SmokeTest`
   - Reference [link](https://evanfang.medium.com/run-specific-android-espresso-tests-by-creating-custom-annotations-using-kotlin-and-command-line-6a90e8728e3b) for more information
3. Firebase to run tests on cloud (physical & virtual devices)
   - Runs locally and needs [configuration](https://firebase.google.com/docs/android/setup) setup
  
   
4. From provided pipelines

## Test Results

Test results can be accessed in the following ways:

1. Locally reports will be available at `app/build/reports/androidTests/connected/index.html` after running tests
2. Test artifacts will be generated after each pipeline's success

Smoke-Test  | All-Test
------------- | -------------
![Smoke-Test](/smoke-test-report.png) | ![All-Test](/all-test-report.png)

3. In Firebase reports when run through Firebase virtual/physical devices

Firebase-Test  | 
------------- | 
![Smoke-Test](/Firebase-Test.png)

## CI Pipelines

The following is an overview of the CI pipelines:

### Steps

1. **Setup Java** - Installs and configures Java 11 with the AdoptOpenJDK distribution
2. **Setup Android SDK** - Installs and configures the Android SDK
3. **Checkout Repo** - Checks out the repository in the environment
4. **Build with Gradle** - Runs the `assembleDebug` Gradle task to build the app
5. **Run UI test via Gradle Virtual Devices** - Runs UI tests with some additional parameters using the `pixel2api29DebugAndroidTest` Gradle task
6. **Upload Test Results** - Uploads the test results to the artifact store

### Triggers

- **All tests**: On pull request to master branch
- **Smoke tests**: On each commit push

Screenshot below shows that pull request cannot happen before all-test pipeline succeeds.
![Pipeline-Diagram](/pipeline-run.png)
## Tools Used

- Android Studio Electric Eel
- Android SDK `28`
- Kotlin `1.4.0`
- Java `11`
- Gradle version `7.5`
- Android Gradle version `7.4.2`
- Android JUnit Runner from AndroidX
- Espresso Core from AndroidX
- Git for versioning control
- GitHub for CI/CD
- Firebase

## Future Enhancements

- Connect Firebase with CI/CD
- Using tags to annotate/group test cases/classes/packages (needs Junit5)

Notes
------
The project was not compiling on my system because of deprecated support libraries and the old Gradle version. I updated the Gradle version and migrated to AndroidX for compatibility, which also allowed me to use the Gradle Unified Test Platform to create a virtual device for testing in pipelines. See this [article](https://proandroiddev.com/running-instrumented-tests-in-gradle) for more information. 
