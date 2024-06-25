package com.bemos.weatherapp.presentation.screen.home.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.weatherapp.domain.model.Location
import com.bemos.weatherapp.ui.theme.WeatherAppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LocationItem(
    location: Location,
    onClick: (String) -> Unit,
    onLongClick: (Location) -> Unit
) {

    var city by remember {
        mutableStateOf(location)
    }

    Card(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .combinedClickable(
                onClick = {
                    onClick(city.city)
                },
                onLongClick = {
                    onLongClick(location)
                }
            )
    ) {
        Column(
            Modifier.padding(10.dp),
        ) {
            Text(
                text = location.city,
                fontSize = 18.sp
            )
        }
    }

    Spacer(modifier = Modifier.height(10.dp))

}

@Preview(showBackground = true)
@Composable
fun LocationItemPreview() {
    WeatherAppTheme {
        LocationItem(
            Location(
                1,
                ""
            ),
            onClick = {},
            onLongClick = {}
        )
    }
}