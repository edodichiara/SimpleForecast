package com.example.simpleforecast.model

import org.threeten.bp.OffsetDateTime

data class HourlyModel(
    val date: OffsetDateTime,
    val temperature: Int,
    val apparentTemperature: Int,
    val rain: Int,
    val weatherCode: Int,
    val snowfall: Int,
    val windSpeed: Int,
    val windGust: Int,
    val windDirection: Int,
    val temperatureUnit: String,
    val apparentTemperatureUnit: String,
    val rainUnit: String,
    val weatherCodeUnit: String,
    val snowfallUnit: String,
    val windSpeedUnit: String,
    val windGustUnit: String,
    val windDirectionUnit: String,
    val weatherCodeDay: Int,
    val sunrise: OffsetDateTime,
    val sunset: OffsetDateTime
)