package com.example.simpleforecast.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.simpleforecast.databinding.FragmentForecastScreenBinding
import com.example.simpleforecast.screen.adapter.ForecastViewPagerAdapter
import com.example.simpleforecast.screen.viewmodel.ForecastScreenViewModel
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
            setWeatherData(PrecipType.CLEAR)
            speed = 600
            emissionRate = 150f
            fadeOutPercent = 0.85f
            angle = 20
            scaleFactor = 2.5f
        }
        setupViewPager()
        return binding.root
    }

    fun setupViewPager(){
        val viewPager: ViewPager2 = binding.viewPager
        val adapter = ForecastViewPagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(viewPager)
    }
}