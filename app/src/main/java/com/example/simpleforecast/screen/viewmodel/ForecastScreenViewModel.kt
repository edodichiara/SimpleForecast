package com.example.simpleforecast.screen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.simpleforecast.network.HourlyRepository
import com.example.simpleforecast.util.HourlyForecastObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastScreenViewModel @Inject constructor(private val hourlyRepository: HourlyRepository) :
    ViewModel() {

    fun retrieveHourlyForecast(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val list = hourlyRepository.getHourlyList()
                Log.d("Forecast hourly", "retrieveHourlyForecast: $list")
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}