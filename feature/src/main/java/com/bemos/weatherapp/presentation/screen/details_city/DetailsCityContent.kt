package com.bemos.weatherapp.presentation.screen.details_city

import android.graphics.Paint.Align
import android.widget.ProgressBar
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bemos.weatherapp.R
import com.bemos.data.remote.retrofit.weather.models.Hour
import com.bemos.weatherapp.presentation.screen.details_city.items.ForecastDayItem
import com.bemos.weatherapp.presentation.screen.details_city.items.ForecastItem
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherByTheHour
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetailsAndMore
import com.bemos.weatherapp.ui.theme.Blue
import com.bemos.weatherapp.ui.theme.LightBlue
import com.bemos.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.delay

@Composable
fun DetailsCityContent(
    weatherDetailsAndMore: WeatherDetailsAndMore,
    weatherByTheHour: List<WeatherByTheHour>,
    onBackClick: () -> Unit,
    onPlusClick: (String) -> Unit,
    addCheck: Boolean,
    progressBarState: Boolean
) {

    Scaffold(
    Modifier.fillMaxSize(),
    topBar = {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = LightBlue
            ),
            shape = RoundedCornerShape(0.dp)
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
                    tint = Color.White
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    if (addCheck) {
                        Icon(
                            modifier = Modifier.clickable {
                                onPlusClick(
                                    weatherDetailsAndMore.city
                                )
                            },
                            painter = painterResource(id = R.drawable.baseline_add_24),
                            contentDescription = "addBtn",
                            tint = Color.White
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
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 50.dp,
                    bottomEnd = 50.dp
                )
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    LightBlue,
                                    Blue
                                )
                            )
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.size(width = 0.dp, height = 20.dp))

                        Text(
                            text = weatherDetailsAndMore.city,
                            fontSize = 24.sp,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.size(width = 0.dp, height = 5.dp))

                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = "${weatherDetailsAndMore.temp}°",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 80.sp,
                        )

                        AsyncImage(
                            modifier = Modifier.size(200.dp),
                            model = "https:${weatherDetailsAndMore.image}",
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.size(width = 0.dp, height = 5.dp))

                        Column(
                            modifier = Modifier.width(200.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = weatherDetailsAndMore.weather,
                                fontSize = 24.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                lineHeight = 30.sp
                            )
                        }

                        if (!progressBarState) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(128.dp),
                                strokeWidth = 8.dp
                            )
                        }

                        Spacer(modifier = Modifier.size(width = 0.dp, height = 50.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.padding(start = 35.dp),
                text = "Today",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(5.dp))
            
            LazyRow {
                item {
                    Spacer(modifier = Modifier.width(20.dp))
                }
                items(
                    items = weatherByTheHour,
                ) {
                    ForecastDayItem(
                        it
                    )
                }
                item {
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.padding(start = 35.dp),
                text = "Next 10 days",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .height(500.dp)
                    .padding(start = 25.dp, end = 25.dp)
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
                forecastDay = listOf(),
                ""
            ),
            listOf(),
            onBackClick = {},
            onPlusClick = {},
            true,
            true
        )
    }
}

//Scaffold(
//Modifier.fillMaxSize(),
//topBar = {
//    Card(
//        modifier = Modifier.padding(5.dp)
//    ) {
//        Row(
//            Modifier
//                .fillMaxWidth()
//                .padding(
//                    10.dp
//                )
//        ) {
//            Icon(
//                modifier = Modifier.clickable {
//                    onBackClick()
//                },
//                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
//                contentDescription = "backBtn",
//                tint = MaterialTheme.colorScheme.primary
//            )
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.End
//            ) {
//                if (addCheck) {
//                    Icon(
//                        modifier = Modifier.clickable {
//                            onPlusClick(
//                                weatherDetailsAndMore.city
//                            )
//                        },
//                        painter = painterResource(id = R.drawable.baseline_add_24),
//                        contentDescription = "addBtn",
//                        tint = MaterialTheme.colorScheme.primary
//                    )
//                }
//            }
//        }
//    }
//}
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(it)
//            .verticalScroll(rememberScrollState())
//    ) {
//        Card(
//            Modifier
//                .fillMaxWidth()
//                .padding(5.dp)
//        ) {
//            Column(
//                Modifier.fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Spacer(modifier = Modifier.size(width = 0.dp, height = 50.dp))
//
//                Text(
//                    text = weatherDetailsAndMore.city,
//                    fontSize = 20.sp,
//                )
//
//                Spacer(modifier = Modifier.size(width = 0.dp, height = 5.dp))
//
//                Text(
//                    text = "${weatherDetailsAndMore.temp}°C",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 40.sp,)
//
//
//
//                Spacer(modifier = Modifier.size(width = 0.dp, height = 5.dp))
//
//                AsyncImage(
//                    modifier = Modifier.size(128.dp),
//                    model = "https:${weatherDetailsAndMore.image}",
//                    contentDescription = null
//                )
//
//                Spacer(modifier = Modifier.size(width = 0.dp, height = 5.dp))
//
//                Text(
//                    text = weatherDetailsAndMore.weather,
//                    fontSize = 20.sp,
//                )
//
//                if (!progressBarState) {
//                    CircularProgressIndicator(
//                        modifier = Modifier.size(128.dp),
//                        strokeWidth = 8.dp
//                    )
//                }
//
//                Spacer(modifier = Modifier.size(width = 0.dp, height = 50.dp))
//            }
//        }
//
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp)
//        ) {
//            LazyRow {
//                items(
//                    items = weatherByTheHour,
//                ) {
//                    ForecastDayItem(
//                        it
//                    )
//                }
//            }
//        }
//
//        Column(
//            modifier = Modifier
//                .height(500.dp)
//                .padding(5.dp)
//        ) {
//            LazyColumn() {
//                items(
//                    items = weatherDetailsAndMore.forecastDay
//                ) {
//                    ForecastItem(
//                        forecastday = it
//                    )
//                }
//            }
//        }
//    }
//}