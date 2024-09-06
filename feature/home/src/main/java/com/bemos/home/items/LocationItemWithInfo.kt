package com.bemos.home.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.LocationDaoDomain
import com.bemos.domain.model.weather_models.ConditionDomain
import com.bemos.domain.model.weather_models.CurrentDomain
import com.bemos.feature.model.LocationWithWeather

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LocationItemWithInfo(
    locationWithWeather: LocationWithWeather,
    onClick: (String) -> Unit,
    onLongClick: (LocationDaoDomain) -> Unit,
) {

    var city by remember {
        mutableStateOf(locationWithWeather)
    }

    Card(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(15.dp))
            .combinedClickable(
                onClick = {
                    onClick(city.location.city)
                },
                onLongClick = {
                    onLongClick(locationWithWeather.location)
                }
            ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            Modifier.padding(10.dp),
        ) {
            Text(
                text = locationWithWeather.location.city,
                fontSize = 22.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.width(270.dp)
                ) {
                    Text(
                        text = locationWithWeather.weather.conditionDomain.text,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 18.sp
                    )
                }

            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "${locationWithWeather.weather.temp_c}°",
                fontSize = 30.sp
            )
        }
    }

    Spacer(modifier = Modifier.height(10.dp))

}

@Preview(showBackground = true)
@Composable
fun LocationItemWithInfoPreview() {

    LocationItemWithInfo(
        locationWithWeather = LocationWithWeather(
            location = LocationDaoDomain(
                1,
                "Moscow"
            ),
            weather = CurrentDomain(
                1,
                        conditionDomain = ConditionDomain(
                            0,
                            "",
                            "1233"
                        ),
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0,
                        0,
                        "",
                        0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0,
                        "",
                        0.0,
                        0.0,
                        0.0,
                        0.0
            )
        ),
        onClick = {},
        onLongClick = {},
    )

}