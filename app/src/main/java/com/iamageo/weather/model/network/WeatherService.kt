package com.iamageo.weather.data.model.network

import com.iamageo.weather.core.RetrofitHelper
import com.iamageo.weather.data.model.WheaterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getWeatherFromLoacation(): WheaterResponse {
        return withContext(Dispatchers.IO) {
            retrofit.create(WheaterAPI::class.java).getWeatherFromLoacation()
        }
    }

}