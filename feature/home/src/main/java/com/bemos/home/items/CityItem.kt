package com.bemos.home.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CityItem(
    cityName: String,
    onClickCity: (String) -> Unit
) {

    Card(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                onClickCity(cityName)
            }
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = cityName
        )

        Spacer(modifier = Modifier.height(15.dp))
    }

    Spacer(modifier = Modifier.height(15.dp))

}

@Preview
@Composable
fun CityItemPreview() {
    CityItem(
        cityName = "Moscow",
        onClickCity = {}
    )
}