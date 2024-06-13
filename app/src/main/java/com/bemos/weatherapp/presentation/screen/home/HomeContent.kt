package com.bemos.weatherapp.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.weatherapp.domain.model.Location
import com.bemos.weatherapp.presentation.screen.home.item.LocationItem
import com.bemos.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun HomeContent(
    listCity: List<Location>,
    onClick: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        Text(
            text = "Weather",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            Modifier.fillMaxWidth()
        ) {
            items(items = listCity) {
                LocationItem(
                    cityLoc = it.city,
                    onClick
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    WeatherAppTheme {
        HomeContent(
            listCity = listOf(
                Location(1, "Moscow"),
                Location(2, "London")
            ),
            onClick = {}
        )
    }
}