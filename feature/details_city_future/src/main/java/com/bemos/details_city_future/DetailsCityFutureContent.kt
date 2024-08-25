package com.bemos.details_city_future

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.details_city_future.item.ForecastDayHourItem
import com.bemos.feature.model.ForecastDayCF
import com.bemos.shared.R
import com.bemos.shared.ui.color.Blue
import com.bemos.shared.ui.color.LightBlue
import com.bemos.shared.ui.color.TransparentWhite


@Composable
fun DetailsCityFutureContent(
    onBackClick: () -> Unit,
    forecastDay: ForecastDayCF
) {

    Scaffold(
        topBar = {
            Row() {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp,
                            end = 10.dp,
                            top = 10.dp,
                            bottom = 10.dp
                        )
                ) {
                    Icon(
                        modifier = Modifier.clickable {
                            onBackClick()
                        },
                        painter = painterResource(id = R.drawable.round_arrow_back_ios_new_24),
                        contentDescription = "backBtn",
                        tint = Color.White
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = forecastDay.forecastDayDomain.date,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Card(
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(50.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    LightBlue,
                                    Blue
                                )
                            )
                        )
                        .padding(5.dp)
                ) {
                    Column {
                        Row() {
                            Image(
                                modifier = Modifier.size(170.dp),
                                painter = painterResource(id = forecastDay.icon),
                                contentDescription = null
                            )

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 5.dp)
                            ) {
                                Spacer(modifier = Modifier.height(45.dp))
                                Text(
                                    text = forecastDay.forecastDayDomain.dayDomain.conditionDomain.text,
                                    fontSize = 20.sp,
                                    color = TransparentWhite
                                )
                                
                                Text(
                                    text = "${forecastDay.forecastDayDomain.dayDomain.maxtemp_c}°/${forecastDay.forecastDayDomain.dayDomain.mintemp_c}°",
                                    fontSize = 30.sp,
                                    color = Color.White
                                )
                            }
                        }
                        
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            Spacer(modifier = Modifier.weight(1f))

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    modifier = Modifier.size(32.dp),
                                    painter = painterResource(id = R.drawable.wind),
                                    contentDescription = null,
                                    tint = Color.White
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "${forecastDay.forecastDayDomain.dayDomain.maxwind_kph}",
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    modifier = Modifier.size(32.dp),
                                    painter = painterResource(id = R.drawable.blur),
                                    contentDescription = null,
                                    tint = Color.White
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "${forecastDay.forecastDayDomain.dayDomain.avghumidity}%",
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    modifier = Modifier.size(32.dp),
                                    painter = painterResource(id = R.drawable.rain),
                                    contentDescription = null,
                                    tint = Color.White
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "${forecastDay.forecastDayDomain.dayDomain.daily_chance_of_rain}%",
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }

                }
            }
            
            Spacer(modifier = Modifier.padding(top = 5.dp))

            Column(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp
                )
            ) {
                LazyColumn() {
                    items(
                        items = forecastDay.weatherHour,
                    ) {
                        ForecastDayHourItem(
                            it
                        )
                    }
                }
            }
        }
    }
}