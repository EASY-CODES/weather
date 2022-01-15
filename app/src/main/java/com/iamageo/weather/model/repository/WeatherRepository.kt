package com.iamageo.weather.data.model.repository

import com.iamageo.weather.data.model.WheaterResponse
import com.iamageo.weather.data.model.network.WeatherService

class WeatherRepository {

    private val service = WeatherService()

    suspend fun getWeatherFromLoacation(): WheaterResponse {
        return service.getWeatherFromLoacation()
    }

}