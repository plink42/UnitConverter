package com.example.unitconverter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainInstrumentedTest {
    @Rule
    @JvmField
    var mainActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testFahrenheitToCelsius() {
        onView(withId(R.id.fahrenheit_value)).perform(typeText("32"))
        onView(withId(R.id.convert_button)).perform(click())
        onView(withId(R.id.celsius_value)).check(matches(withText("0.0")))
    }

    @Test
    fun testCelsiusToFahrenheit() {
        onView(withId(R.id.celsius_value)).perform(typeText("0"))
        onView(withId(R.id.convert_button)).perform(click())
        onView(withId(R.id.fahrenheit_value)).check(matches(withText("32.0")))
    }

    @Test
    fun testFahrenheitToCelsiusNegative() {
        onView(withId(R.id.fahrenheit_value)).perform(typeText("-40"))
        onView(withId(R.id.convert_button)).perform(click())
        onView(withId(R.id.celsius_value)).check(matches(withText("-40.0")))
    }

    @Test
    fun testCelsiusToFahrenheitNegative() {
        onView(withId(R.id.celsius_value)).perform(typeText("-40"))
        onView(withId(R.id.convert_button)).perform(click())
        onView(withId(R.id.fahrenheit_value)).check(matches(withText("-40.0")))
    }

    @Test
    fun testFahrenheitWithEnter() {
        onView(withId(R.id.fahrenheit_value)).perform(typeText("32\n"))
        onView(withId(R.id.celsius_value)).check(matches(withText("0.0")))
    }

    @Test
    fun testCelsiusWithEnter() {
        onView(withId(R.id.celsius_value)).perform(typeText("-40\n"))
        onView(withId(R.id.fahrenheit_value)).check(matches(withText("-40.0")))
    }
}