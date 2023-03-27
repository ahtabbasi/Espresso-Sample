package com.abnamro.apps.referenceandroid.util.annotations

// Annotation to group testcases
// This annotation targets functions/methods
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class SmokeTest