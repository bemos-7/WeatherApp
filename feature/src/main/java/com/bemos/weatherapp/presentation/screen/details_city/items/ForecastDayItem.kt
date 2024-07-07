package com.bemos.weatherapp.presentation.screen.details_city.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherByTheHour

@Composable
fun ForecastDayItem(
    weatherByTheHour: WeatherByTheHour
) {
    Card(
        Modifier
            .padding(10.dp),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                top = 15.dp,
                bottom = 15.dp,
                start = 10.dp,
                end = 10.dp
            ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = weatherByTheHour.time
            )

            Spacer(modifier = Modifier.height(10.dp))

//            AsyncImage(
//                modifier = Modifier.size(64.dp, 64.dp),
//                model = "https:${weatherByTheHour.hour.conditionDomain.icon}",
//                contentDescription = null,
//            )

            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(id = weatherByTheHour.icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${weatherByTheHour.hour.temp_c}°"
            )
        }
    }
}