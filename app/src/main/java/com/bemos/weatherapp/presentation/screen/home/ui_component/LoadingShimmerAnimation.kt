package com.bemos.weatherapp.presentation.screen.home.ui_component

import android.view.View
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.weatherapp.R
import com.bemos.weatherapp.presentation.screen.details_city.items.ForecastDayItem
import com.bemos.weatherapp.presentation.screen.details_city.items.ForecastItem
import com.bemos.weatherapp.presentation.screen.home.icon_converter.IconConverter
import com.bemos.weatherapp.ui.theme.Blue
import com.bemos.weatherapp.ui.theme.LightBlue
import com.bemos.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun LoadingShimmerAnimation() {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()

    val shimmerColor = listOf(
        Color(0xE9DFDFDF),
        Color(0xA1CECECE),
        Color(0xE9DFDFDF)
    )

    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 5000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing,

            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        shimmerColor,
        start = Offset.Zero,
        end = Offset(translateAnimation, translateAnimation)
    )

    ShimmerDetailsCityContent(brush)
}

@Composable
fun ShimmerDetailsCityContent(brush: Brush) {
    Scaffold(
        Modifier.fillMaxSize(),
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
                            brush
                        )
                        .size(500.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Spacer(modifier = Modifier
                .padding(start = 35.dp)
                .width(60.dp)
                .height(25.dp)
                .background(brush))

            Spacer(modifier = Modifier.height(5.dp))

            LazyRow(
                Modifier.fillMaxWidth()
            ) {
                item {
                    Spacer(
                        modifier = Modifier.width(20.dp)
                    )
                }
                items(4) {
                    Card(
                        Modifier
                            .padding(
                                10.dp
                            ),
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
                                )
                                .width(65.dp)
                                .height(115.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Spacer(modifier = Modifier
                .padding(start = 35.dp)
                .width(130.dp)
                .height(25.dp)
                .background(brush))

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier.height(200.dp)
                    .padding(
                        start = 25.dp,
                        end = 25.dp
                    )
            ) {
                LazyColumn(
                    Modifier.fillMaxWidth()
                ) {
                    items(1) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .background(brush),
                            ) {

                            }
                        }
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun LoadingShimmerAnimationPreview() {
    WeatherAppTheme {
        LoadingShimmerAnimation()
    }
}