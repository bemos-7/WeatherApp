package com.bemos.details_city.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bemos.feature.model.WeatherByTheHour

@Composable
fun ForecastDayDialog(
    weatherByTheHour: WeatherByTheHour,
    onDismissRequest: () -> Unit
) {
    if (weatherByTheHour != null) {
        Dialog(
            onDismissRequest = {
                onDismissRequest()
            }
        ) {
            Card(
                modifier = Modifier.clickable {
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
                        text = weatherByTheHour.time,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Image(
                        painter = painterResource(
                            id = weatherByTheHour.icon
                        ),
                        contentDescription = null
                    )

                    Text(
                        text = weatherByTheHour.hour.conditionDomain.text,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "${weatherByTheHour.hour.temp_c}°",
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(25.dp))
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