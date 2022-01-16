package com.iamageo.weather.data.model.network

import com.iamageo.weather.data.model.WheaterResponse
import com.iamageo.weather.model.network.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherService @Inject constructor(private val api: API) {

    suspend fun getWeatherFromLoacation(): WheaterResponse {
        return withContext(Dispatchers.IO) {
            api.getWeatherFromLoacation()
        }
    }

}