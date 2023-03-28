package com.example.simpleforecast.util

import com.example.simpleforecast.model.HourlyModel

object HourlyForecastObject {
    private var listHour: List<HourlyModel>? = null

    fun saveHourlyList(list: List<HourlyModel>){
        listHour = list
    }

    fun getHourlyList(): List<HourlyModel>? = listHour
}