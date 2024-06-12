package com.bemos.weatherapp.presentation.screen.cities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun CitiesContent(
    onClick: (String) -> Unit,
    temp: String
) {

    var city by remember {
        mutableStateOf("")
    }
    
    var temp by remember {
        mutableStateOf(temp)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = city,
            onValueChange = { city = it }
        )

        Spacer(modifier = Modifier.size(height = 10.dp, width = 0.dp))

        Button(
            onClick = {
                onClick(city)
            }
        ) {
            Text(
                text = "Sumbit"
            )
        }

        Spacer(modifier = Modifier.size(height = 10.dp, width = 0.dp))
        
        Text(
            text = temp 
        )
    }

}

@Preview(showBackground = true)
@Composable
fun CitiesContentPreview() {
    WeatherAppTheme {
        CitiesContent(
            onClick = {},
            "11233"
        )
    }
}