package com.iamageo.weather.domain

import com.iamageo.weather.data.model.WheaterResponse
import com.iamageo.weather.data.model.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(private val repository: WeatherRepository) {

    suspend operator fun invoke(): WheaterResponse = repository.getWeatherFromLoacation()

}