package com.example.simpleforecast.screen

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.simpleforecast.R
import com.example.simpleforecast.databinding.FragmentForecastScreenBinding
import com.example.simpleforecast.databinding.FragmentTodayTaskBinding
import com.example.simpleforecast.model.HourlyModel
import com.example.simpleforecast.screen.viewmodel.TodayTaskFragmentViewModel
import com.example.simpleforecast.util.HourlyForecastObject
import dagger.hilt.android.AndroidEntryPoint
import org.threeten.bp.OffsetDateTime

@AndroidEntryPoint
class TodayTaskFragment : Fragment() {
    private var _binding: FragmentTodayTaskBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TodayTaskFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodayTaskBinding.inflate(inflater, container, false)
        makeGradientOnTextView()
        viewModel.retrieveHourlyForecast()
        return binding.root
    }

    private fun makeGradientOnTextView() {
        val topColor = Color.parseColor("#FFE8FCFF")
        val bottomColor = Color.parseColor("#80E8FCFF")
        val gradient = LinearGradient(
            0f,
            0f,
            0f,
            binding.temperature.textSize,
            topColor,
            bottomColor,
            Shader.TileMode.CLAMP
        )
        binding.temperature.paint.shader = gradient
    }


}