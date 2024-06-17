package com.bemos.weatherapp.presentation.screen.details_city

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.weatherapp.R
import com.bemos.weatherapp.data.remote.retrofit.weather.models.Hour
import com.bemos.weatherapp.presentation.screen.details_city.items.ForecastDayItem
import com.bemos.weatherapp.presentation.screen.details_city.items.ForecastItem
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetailsAndMore
import com.bemos.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun DetailsCityContent(
    weatherDetailsAndMore: WeatherDetailsAndMore,
    weatherByTheHour: List<Hour>,
    onBackClick: () -> Unit,
    onPlusClick: () -> Unit,
    addCheck: Boolean
) {

    val isAdded = remember {
        mutableStateOf(addCheck)
    }

    Scaffold(
        Modifier.fillMaxSize(),
        topBar = {
            Card(
                modifier = Modifier.padding(5.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            10.dp
                        )
                ) {
                    Icon(
                        modifier = Modifier.clickable {
                            onBackClick()
                        },
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "backBtn",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End
                    ) {
                        if (isAdded.value) {
                            Icon(
                                modifier = Modifier.clickable {
                                    onPlusClick()
                                },
                                painter = painterResource(id = R.drawable.baseline_add_24),
                                contentDescription = "addBtn",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.size(width = 0.dp, height = 50.dp))

                    Text(
                        text = weatherDetailsAndMore.city,
                        fontSize = 20.sp,
                    )

                    Spacer(modifier = Modifier.size(width = 0.dp, height = 5.dp))

                    Text(
                        text = "${weatherDetailsAndMore.temp}°C",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                    )

                    Spacer(modifier = Modifier.size(width = 0.dp, height = 5.dp))

                    Text(
                        text = weatherDetailsAndMore.weather,
                        fontSize = 20.sp,
                    )

                    Spacer(modifier = Modifier.size(width = 0.dp, height = 50.dp))
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                LazyRow {
                    items(
                        items = weatherByTheHour
                    ) {
                        ForecastDayItem(
                            it
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
            ) {
                LazyColumn() {
                    items(
                        items = weatherDetailsAndMore.forecastDay
                    ) {
                        ForecastItem(
                            forecastday = it
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsCityContentPreview() {
    WeatherAppTheme {
        DetailsCityContent(
            weatherDetailsAndMore = WeatherDetailsAndMore(
                "Moscow",
                "23",
                weather = "Clear",
                forecastDay = listOf()
            ),
            listOf(),
            onBackClick = {},
            onPlusClick = {},
            true
        )
    }
}