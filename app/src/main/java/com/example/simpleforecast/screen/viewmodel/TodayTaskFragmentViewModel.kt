package com.example.simpleforecast.screen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.simpleforecast.network.HourlyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodayTaskFragmentViewModel @Inject constructor(private val repository: HourlyRepository) : ViewModel() {

    init {
        retrieveHourlyForecast()
    }

    fun retrieveHourlyForecast(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val list = repository.getHourlyList()
                Log.d("TodayTaskFragmentViewModel call:", "retrieveHourlyForecast: $list")
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}