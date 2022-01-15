package com.iamageo.weather.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.weather.domain.WeatherUseCase
import com.iamageo.weather.data.model.WheaterResponse
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    var weather = MutableLiveData<WheaterResponse>()

    var weatherUseCase = WeatherUseCase()

    fun getWeatherFromLoacation() {
        viewModelScope.launch {
            weather.value = weatherUseCase.invoke()
        }
    }

}