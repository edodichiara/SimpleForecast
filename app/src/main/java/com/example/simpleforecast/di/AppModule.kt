package com.example.simpleforecast.di

import com.example.simpleforecast.network.ForecastObject
import com.example.simpleforecast.network.HourlyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideHourlyRepository(forecastObject: ForecastObject): HourlyRepository =
        HourlyRepository(forecastObject)

    @Singleton
    @Provides
    fun provideForecastObject(): ForecastObject = ForecastObject

}