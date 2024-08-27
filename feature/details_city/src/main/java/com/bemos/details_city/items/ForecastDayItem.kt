package com.bemos.details_city.items

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bemos.shared.ui.color.Blue
import com.bemos.shared.ui.color.ContainerBlack
import com.bemos.shared.ui.color.LightBlue

@Composable
fun ForecastDayItem(
    weatherByTheHour: com.bemos.feature.model.WeatherByTheHour
) {
    Log.d("timeChecker", weatherByTheHour.time + " " + weatherByTheHour.cityTime)
    if (weatherByTheHour.time == weatherByTheHour.cityTime) {
        ForecastDayItemCard(
            brush = Brush.verticalGradient(
                listOf(
                    LightBlue,
                    Blue
                )
            ),
            color = Color.White,
            weatherByTheHour = weatherByTheHour
        )
    } else {
        ForecastDayItemCard(
            brush = Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.onTertiaryContainer,
                    MaterialTheme.colorScheme.onTertiaryContainer
                )
            ),
            color = MaterialTheme.colorScheme.onBackground,
            weatherByTheHour = weatherByTheHour
        )
    }

//    Card(
//        Modifier
//            .padding(10.dp),
//        shape = RoundedCornerShape(22.dp)
//    ) {
//        Column(
//            modifier = Modifier.padding(
//                top = 15.dp,
//                bottom = 15.dp,
//                start = 10.dp,
//                end = 10.dp
//            ),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = weatherByTheHour.time
//            )
//
//            Spacer(modifier = Modifier.height(10.dp))
//
////            AsyncImage(
////                modifier = Modifier.size(64.dp, 64.dp),
////                model = "https:${weatherByTheHour.hour.conditionDomain.icon}",
////                contentDescription = null,
////            )
//
//            Image(
//                modifier = Modifier.size(64.dp),
//                painter = painterResource(id = weatherByTheHour.icon),
//                contentDescription = null
//            )
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            Text(
//                text = "${weatherByTheHour.hour.temp_c}°"
//            )
//        }
//    }
}

@Composable
fun ForecastDayItemCard(
    brush: Brush,
    color: Color,
    weatherByTheHour: com.bemos.feature.model.WeatherByTheHour
) {
    Card(
        Modifier
            .padding(10.dp),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier
                .background(brush)
                .padding(
                    top = 15.dp,
                    bottom = 15.dp,
                    start = 10.dp,
                    end = 10.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = weatherByTheHour.time,
                color = color
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
                text = "${weatherByTheHour.hour.temp_c}°",
                color = color
            )
        }
    }
}
