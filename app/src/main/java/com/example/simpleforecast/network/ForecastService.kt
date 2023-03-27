package com.example.simpleforecast.network

import com.example.simpleforecast.network.dto.HourlyForecastDTO
import retrofit2.Response
import retrofit2.http.GET

interface ForecastService {
    @GET("forecast?latitude=37.81&longitude=13.64&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,precipitation,rain,showers,snowfall,weathercode,cloudcover,visibility,windspeed_10m,winddirection_10m,windgusts_10m,uv_index,uv_index_clear_sky&daily=weathercode,sunrise,sunset,precipitation_sum,rain_sum,snowfall_sum&forecast_days=1&timezone=auto")
    suspend fun hourlyForecastList(): Response<HourlyForecastDTO>
}


//https://api.open-meteo.com/v1/forecast?latitude=37.81&longitude=13.64&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,precipitation_probability,precipitation,rain,showers,snowfall,weathercode,cloudcover,visibility,windspeed_10m,winddirection_10m,windgusts_10m,uv_index,uv_index_clear_sky

//https://api.open-meteo.com/v1/forecast?latitude=37.81&longitude=13.63&hourly=temperature_2m,apparent_temperature,precipitation_probability,precipitation,surface_pressure,cloudcover_mid,visibility,winddirection_10m&daily=weathercode,sunrise,sunset,precipitation_sum,rain_sum,snowfall_sum&timezone=auto