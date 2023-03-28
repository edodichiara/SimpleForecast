package com.example.simpleforecast.screen.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleforecast.model.HourlyModel
import com.example.simpleforecast.network.HourlyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class TodayTaskResult(){
    data class Success(val data: List<HourlyModel>): TodayTaskResult()
    data class Error(val e: Exception): TodayTaskResult()
}

@HiltViewModel
class TodayTaskFragmentViewModel @Inject constructor(private val repository: HourlyRepository) : ViewModel() {
    private var _todayTaskResult = MutableLiveData<TodayTaskResult>()
    val todayTaskResult: LiveData<TodayTaskResult>
        get() = _todayTaskResult

    fun retrieveHourlyForecast(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val list = repository.getHourlyList()
                _todayTaskResult.value = TodayTaskResult.Success(list)
                Log.d("TodayTaskFragmentViewModel call:", "retrieveHourlyForecast: $list")
            } catch (e: Exception){
                _todayTaskResult.value = TodayTaskResult.Error(e)
            }
        }
    }
}