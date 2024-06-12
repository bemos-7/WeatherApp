package com.bemos.weatherapp.presentation.screen.cities.vm

import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CitiesViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    val temperature = MutableStateFlow("")

    suspend fun getWeather(
        city: String
    ) {
        viewModelScope.launch {
            val response = getWeatherUseCase.execute(
                city
            )

            if (response.isSuccessful) {
                temperature.value = response.body()!!.current.temp_c.toString()
            }
        }
    }

}