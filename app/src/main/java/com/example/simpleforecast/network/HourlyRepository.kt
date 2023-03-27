package com.example.simpleforecast.network

import com.example.simpleforecast.model.HourlyModel
import javax.inject.Inject

class HourlyRepository @Inject constructor(private val forecastObject: ForecastObject) {
    suspend fun getHourlyList(): List<HourlyModel>{
        return forecastObject.getHourlyList()
    }

}