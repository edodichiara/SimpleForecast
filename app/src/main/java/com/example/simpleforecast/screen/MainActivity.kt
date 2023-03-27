package com.example.simpleforecast.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleforecast.databinding.ActivityMainBinding
import com.github.matteobattilana.weather.PrecipType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.weatherView.apply {
            setWeatherData(PrecipType.RAIN)
            emissionRate = 1f
        }
    }
}