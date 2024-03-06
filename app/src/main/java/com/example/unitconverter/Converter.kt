package com.example.unitconverter

import java.math.BigDecimal
import java.math.RoundingMode

class Converter {
    internal fun convertFahrenheitToCelsius(fahrenheit: Double): Double {
        return BigDecimal((fahrenheit - 32) * 5 / 9).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    }

    internal fun convertCelsiusToFahrenheit(celsius: Double): Double {
        return BigDecimal(celsius * 9 / 5 + 32).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    }
}