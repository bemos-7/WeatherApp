package com.bemos.weatherapp.presentation.screen.search_city.item

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CityItem(
    cityName: String
) {

    Text(
        text = cityName
    )
    
    Spacer(modifier = Modifier.height(10.dp))

}