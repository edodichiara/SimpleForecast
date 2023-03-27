package com.example.simpleforecast.screen

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.simpleforecast.ForecastScreenViewModel
import com.example.simpleforecast.databinding.FragmentForecastScreenBinding
import com.github.matteobattilana.weather.PrecipType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastScreen : Fragment() {
    private val viewModel: ForecastScreenViewModel by viewModels()
    private var _binding: FragmentForecastScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForecastScreenBinding.inflate(inflater, container, false)

        binding.weatherView.apply {
            setWeatherData(PrecipType.RAIN)
            speed = 600
            emissionRate = 60f
            fadeOutPercent = 0.85f
            angle = 20
        }

        viewModel.retrieveHourlyForecast()

        val topColor = Color.parseColor("#FFE8FCFF")
        val bottomColor = Color.parseColor("#80E8FCFF")
        val gradient = LinearGradient(0f, 0f, 0f, binding.temperature.textSize, topColor, bottomColor, Shader.TileMode.CLAMP)
        binding.temperature.paint.shader = gradient

        return binding.root
    }
}