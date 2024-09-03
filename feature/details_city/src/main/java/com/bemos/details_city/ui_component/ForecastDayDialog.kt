package com.bemos.details_city.ui_component

import android.view.Window
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider
import com.bemos.details_city.model.WeatherByTheHourVisibleMode
import com.bemos.feature.model.WeatherByTheHour

@Composable
fun ForecastDayDialog(
    weatherByTheHourVisibleMode: WeatherByTheHourVisibleMode,
    onDismissRequest: () -> Unit
) {
    if (weatherByTheHourVisibleMode.weatherByTheHour != null) {

        var animateIn by remember { mutableStateOf(false) }
        LaunchedEffect(Unit) { animateIn = true }

        Dialog(
            onDismissRequest = {
                onDismissRequest()
            }
        ) {
            AnimatedVisibility(
                visible = animateIn,
                enter = fadeIn(
                    spring(stiffness = Spring.StiffnessHigh)
                ) + scaleIn(
                    initialScale = .1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                ),
                exit = scaleOut(
                    targetScale = 0.1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                ) + fadeOut(
                    animationSpec = spring(stiffness = Spring.StiffnessHigh)
                )
            ) {
                Card(
                    modifier = Modifier
                        .clip(RoundedCornerShape(35.dp))
                        .clickable {
                            onDismissRequest()
                        },
                    shape = RoundedCornerShape(35.dp)
                ) {
                    Column(
                        modifier = Modifier.background(
                            MaterialTheme.colorScheme.onTertiaryContainer
                        ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(25.dp))
                        Text(
                            text = weatherByTheHourVisibleMode.weatherByTheHour.time,
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Image(
                            painter = painterResource(
                                id = weatherByTheHourVisibleMode.weatherByTheHour.icon
                            ),
                            contentDescription = null
                        )

                        Box(
                            modifier = Modifier
                                .width(250.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = weatherByTheHourVisibleMode.weatherByTheHour.hour.conditionDomain.text,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "${weatherByTheHourVisibleMode.weatherByTheHour.hour.temp_c}°",
                            fontSize = 45.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(25.dp))
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun ForecastDayDialogPreview() {
//    ForecastDayDialog(
//        onDismissRequest = {}
//    )
}