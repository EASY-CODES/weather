package com.iamageo.weather.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.weather.data.model.WheaterResponse
import com.iamageo.weather.domain.WeatherUseCase
import kotlinx.coroutines.launch

class WeatherViewModel @ViewModelInject constructor(private val weatherUseCase: WeatherUseCase) :
    ViewModel() {

    var weather = MutableLiveData<WheaterResponse>()

    fun getWeatherFromLoacation() {
        viewModelScope.launch {
            weather.value = weatherUseCase.invoke()
        }
    }

}