package com.bemos.details_city_future.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bemos.shared.ui.color.ContainerBlack

@Composable
fun ForecastDayHourItem(
    weatherHour: com.bemos.feature.model.WeatherHour
) {
    Card(
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.onTertiaryContainer
                )
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = weatherHour.normalTime,
                color = MaterialTheme.colorScheme.onBackground
            )

            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(64.dp),
                    painter = painterResource(id = weatherHour.icon),
                    contentDescription = null
                )

                Text(
                    text = weatherHour.hourDomain.conditionDomain.text,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Text(
                text = "${weatherHour.hourDomain.temp_c}°",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
    
    Spacer(modifier = Modifier.height(15.dp))

}