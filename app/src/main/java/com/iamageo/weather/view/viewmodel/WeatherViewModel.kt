package com.iamageo.weather.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.weather.domain.WeatherUseCase
import com.iamageo.weather.data.model.WheaterResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherUseCase: WeatherUseCase): ViewModel() {

    var weather = MutableLiveData<WheaterResponse>()

    fun getWeatherFromLoacation() {
        viewModelScope.launch {
            weather.value = weatherUseCase.invoke()
        }
    }

}