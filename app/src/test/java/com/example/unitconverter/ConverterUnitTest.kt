package com.example.unitconverter

import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterUnitTest {
    private val converter = Converter()

    @Test
    fun testFahrenheitToCelsiusConversion() {
        val fahrenheit = 32.0
        val expectedCelsius = 0.0
        val actualCelsius = converter.convertFahrenheitToCelsius(fahrenheit)
        assertEquals(expectedCelsius, actualCelsius, 0.01)
    }

    @Test
    fun testCelsiusToFahrenheitConversion() {
        val celsius = 0.0
        val expectedFahrenheit = 32.0
        val actualFahrenheit = converter.convertCelsiusToFahrenheit(celsius)
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.01)
    }

    @Test
    fun testFahrenheitToCelsiusConversionNegative() {
        val fahrenheit = -40.0
        val expectedCelsius = -40.0
        val actualCelsius = converter.convertFahrenheitToCelsius(fahrenheit)
        assertEquals(expectedCelsius, actualCelsius, 0.01)
    }

    @Test
    fun testCelsiusToFahrenheitConversionNegative() {
        val celsius = -40.0
        val expectedFahrenheit = -40.0
        val actualFahrenheit = converter.convertCelsiusToFahrenheit(celsius)
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.01)
    }
}