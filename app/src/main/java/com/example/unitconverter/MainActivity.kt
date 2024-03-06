package com.example.unitconverter

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val converter = Converter()

        val fahrenheitInput = findViewById<EditText>(R.id.fahrenheit_value)
        val celsiusInput = findViewById<EditText>(R.id.celsius_value)

        fahrenheitInput.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val fahrenheit = fahrenheitInput.text.toString().toDouble()
                val celsius = converter.convertFahrenheitToCelsius(fahrenheit).toString()
                celsiusInput.setText(celsius)
                return@OnKeyListener true
            }
            false
        })

        celsiusInput.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val celsius = celsiusInput.text.toString().toDouble()
                val fahrenheit = converter.convertCelsiusToFahrenheit(celsius).toString()
                fahrenheitInput.setText(fahrenheit)
                return@OnKeyListener true
            }
            false
        })

        fahrenheitInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                fahrenheitInput.text.clear()
                celsiusInput.text.clear()
            }
        }
        celsiusInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                celsiusInput.text.clear()
                fahrenheitInput.text.clear()
            }
        }
        val convertButton = findViewById<Button>(R.id.convert_button)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        convertButton.setOnClickListener {
            if (fahrenheitInput.text.isNotEmpty()) {
                val fahrenheit = fahrenheitInput.text.toString().toDouble()
                val celsius = converter.convertFahrenheitToCelsius(fahrenheit).toString()
                celsiusInput.setText(celsius)
            } else if (celsiusInput.text.isNotEmpty()) {
                val celsius = celsiusInput.text.toString().toDouble()
                val fahrenheit = converter.convertCelsiusToFahrenheit(celsius).toString()
                fahrenheitInput.setText(fahrenheit)
            } else {
                fahrenheitInput.error = "Please enter a value"
            }
        }
    }
}