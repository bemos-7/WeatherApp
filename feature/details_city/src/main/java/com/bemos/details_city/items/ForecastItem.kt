package com.bemos.details_city.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.details_city.model.ForecastDayAndIcon
import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.shared.colors.ContainerBlack


@Composable
fun ForecastItem(
    forecastDay: ForecastDayAndIcon,
    onForecastCLick: (com.bemos.domain.model.weather_models.ForecastdayDomain) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onForecastCLick(forecastDay.forecastDay)
            },
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(ContainerBlack)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = forecastDay.forecastDay.date
                )
                Spacer(modifier = Modifier.height(10.dp))
//                AsyncImage(
//                    modifier = Modifier.size(64.dp),
//                    model = "https:${forecastday.dayDomain.conditionDomain.icon}",
//                    contentDescription = null
//                )
                Image(
                    modifier = Modifier.size(64.dp),
                    painter = painterResource(
                        id = forecastDay.icon
                    ),
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${forecastDay.forecastDay.dayDomain.maxtemp_c}°",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }

    Spacer(modifier = Modifier.height(20.dp))

}