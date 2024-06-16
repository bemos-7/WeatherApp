package com.bemos.weatherapp.presentation.screen.search_city

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bemos.weatherapp.data.remote.retrofit.city.model.City
import com.bemos.weatherapp.data.remote.retrofit.city.model.Data
import com.bemos.weatherapp.presentation.screen.search_city.item.CityItem
import com.bemos.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun SearchCityContent(
    cityList: City
) {

    val citiesList = remember {
        mutableListOf<String>()
    }

    cityList.data.forEach {
        it.cities.forEach {
            citiesList.add(it)
        }
    }

    Column(
        Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(items = citiesList) {
                CityItem(
                    cityName = it
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SearchCityContentPreview() {
    WeatherAppTheme {
        SearchCityContent(
            cityList = City(
                listOf()
            )
        )
    }
}