package com.bemos.weatherapp.presentation.screen.details_city.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bemos.weatherapp.data.remote.retrofit.weather.models.Forecastday

@Composable
fun ForecastItem(
    forecastday: Forecastday
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = forecastday.date
                )
                Spacer(modifier = Modifier.height(10.dp))
                AsyncImage(
                    modifier = Modifier.size(64.dp),
                    model = "https:${forecastday.day.condition.icon}",
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${forecastday.day.maxtemp_c}°",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }

    Spacer(modifier = Modifier.height(10.dp))

}