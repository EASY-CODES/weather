package com.iamageo.weather.domain

import com.iamageo.weather.data.model.WheaterResponse
import com.iamageo.weather.data.model.repository.WeatherRepository

class WeatherUseCase {

    private val repository = WeatherRepository()

    suspend operator fun invoke(): WheaterResponse = repository.getWeatherFromLoacation()

}