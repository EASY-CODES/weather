package com.iamageo.weather.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.iamageo.weather.data.model.WheaterResponse
import com.iamageo.weather.databinding.ActivityMainBinding
import com.iamageo.weather.view.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.text.SimpleDateFormat
import java.util.*

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class WeatherMain : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getWeather()
        setupObservers()
    }

    private fun getWeather() {
        weatherViewModel.getWeatherFromLoacation()
    }

    private fun setupObservers() {
        weatherViewModel.weather.observe(this, Observer {
            setupViewWeatherInfo(it)
        })
    }

    private fun setupViewWeatherInfo(response: WheaterResponse) {
        binding.location.text = response.name
        binding.updateAt.text =
            "Updated at: " + SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                Date(response.dt * 1000)
            )
        binding.status.text = response.weather[0].description.capitalize(Locale.ROOT)
        binding.temp.text = response.main.temp.toInt().toString() + "ºC"
        binding.minTemp.text = "Min Temp: " + response.main.tempMin + "°C"
        binding.maxTemp.text = "Min Temp: " + response.main.tempMax + "°C"
        binding.sunrise.text =
            SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(response.sys.sunrise * 1000))
        binding.sunset.text =
            SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(response.sys.sunset * 1000))
        binding.wind.text = response.wind.speed.toString()
        binding.pressure.text = response.main.pressure.toString()
        binding.humidity.text = response.main.humidity.toString()
    }

}