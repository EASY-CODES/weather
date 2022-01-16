package com.iamageo.weather.model.network

import com.iamageo.weather.data.model.WheaterResponse
import retrofit2.http.GET

interface API {
    @GET("weather?q=belem,br&units=metric&appid=5baa9cff13e962caf43a80119941dbb2")
    suspend fun getWeatherFromLoacation(): WheaterResponse
}