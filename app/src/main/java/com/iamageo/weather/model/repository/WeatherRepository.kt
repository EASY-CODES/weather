package com.iamageo.weather.data.model.repository

import com.iamageo.weather.data.model.WheaterResponse
import com.iamageo.weather.data.model.network.WeatherService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val service: WeatherService) {

    suspend fun getWeatherFromLoacation(): WheaterResponse {
        return service.getWeatherFromLoacation()
    }

}