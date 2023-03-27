package com.example.simpleforecast.network.dto
import com.example.simpleforecast.model.HourlyModel
import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime


data class HourlyForecastDTO(
    @SerializedName("daily")
    val daily: Daily,
    @SerializedName("elevation")
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("hourly")
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int
){
    fun toDomain(): List<HourlyModel>{
        return this.hourly.time.mapIndexed{ index, date ->
            HourlyModel(
                date = date,
                temperature = this.hourly.temperature2m.getOrNull(index)?.toInt() ?: 0,
                apparentTemperature = this.hourly.apparentTemperature.getOrNull(index)?.toInt() ?: 0,
                rain = this.hourly.rain.getOrNull(index)?.toInt() ?: 0,
                weatherCode = this.hourly.weathercode.getOrNull(index)?.toInt() ?: 0,
                snowfall = this.hourly.snowfall.getOrNull(index)?.toInt() ?: 0,
                windSpeed = this.hourly.windspeed10m.getOrNull(index)?.toInt() ?: 0,
                windGust = this.hourly.windgusts10m.getOrNull(index)?.toInt() ?: 0,
                windDirection = this.hourly.winddirection10m.getOrNull(index)?.toInt() ?: 0,
                temperatureUnit = this.hourlyUnits.temperature2m,
                apparentTemperatureUnit = this.hourlyUnits.apparentTemperature,
                rainUnit = this.hourlyUnits.rain,
                weatherCodeUnit = this.hourlyUnits.weathercode,
                snowfallUnit = this.hourlyUnits.snowfall,
                windSpeedUnit = this.hourlyUnits.windspeed10m,
                windGustUnit = this.hourlyUnits.windgusts10m,
                windDirectionUnit = this.hourlyUnits.winddirection10m,
                weatherCodeDay = this.daily.weathercode.getOrNull(index)?.toInt() ?: 0,
                sunrise = this.daily.sunrise.getOrNull(index) ?: OffsetDateTime.now(),
                sunset = this.daily.sunrise.getOrNull(index) ?: OffsetDateTime.now()
            )
        }
    }
}

data class Hourly(
    @SerializedName("apparent_temperature")
    val apparentTemperature: List<Double>,
    @SerializedName("cloudcover")
    val cloudcover: List<Int>,
    @SerializedName("precipitation")
    val precipitation: List<Double>,
    @SerializedName("precipitation_probability")
    val precipitationProbability: List<Int>,
    @SerializedName("rain")
    val rain: List<Double>,
    @SerializedName("relativehumidity_2m")
    val relativehumidity2m: List<Int>,
    @SerializedName("showers")
    val showers: List<Double>,
    @SerializedName("snowfall")
    val snowfall: List<Double>,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<OffsetDateTime>,
    @SerializedName("uv_index")
    val uvIndex: List<Double>,
    @SerializedName("uv_index_clear_sky")
    val uvIndexClearSky: List<Double>,
    @SerializedName("visibility")
    val visibility: List<Double>,
    @SerializedName("weathercode")
    val weathercode: List<Int>,
    @SerializedName("winddirection_10m")
    val winddirection10m: List<Int>,
    @SerializedName("windgusts_10m")
    val windgusts10m: List<Double>,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Double>
)

data class HourlyUnits(
    @SerializedName("apparent_temperature")
    val apparentTemperature: String,
    @SerializedName("cloudcover")
    val cloudcover: String,
    @SerializedName("precipitation")
    val precipitation: String,
    @SerializedName("precipitation_probability")
    val precipitationProbability: String,
    @SerializedName("rain")
    val rain: String,
    @SerializedName("relativehumidity_2m")
    val relativehumidity2m: String,
    @SerializedName("showers")
    val showers: String,
    @SerializedName("snowfall")
    val snowfall: String,
    @SerializedName("temperature_2m")
    val temperature2m: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("uv_index")
    val uvIndex: String,
    @SerializedName("uv_index_clear_sky")
    val uvIndexClearSky: String,
    @SerializedName("visibility")
    val visibility: String,
    @SerializedName("weathercode")
    val weathercode: String,
    @SerializedName("winddirection_10m")
    val winddirection10m: String,
    @SerializedName("windgusts_10m")
    val windgusts10m: String,
    @SerializedName("windspeed_10m")
    val windspeed10m: String
)

data class Daily(
    @SerializedName("precipitation_sum")
    val precipitationSum: List<Double>,
    @SerializedName("rain_sum")
    val rainSum: List<Double>,
    @SerializedName("snowfall_sum")
    val snowfallSum: List<Double>,
    @SerializedName("sunrise")
    val sunrise: List<OffsetDateTime>,
    @SerializedName("sunset")
    val sunset: List<OffsetDateTime>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("weathercode")
    val weathercode: List<Int>
)

data class DailyUnits(
    @SerializedName("precipitation_sum")
    val precipitationSum: String,
    @SerializedName("rain_sum")
    val rainSum: String,
    @SerializedName("snowfall_sum")
    val snowfallSum: String,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("weathercode")
    val weathercode: String
)