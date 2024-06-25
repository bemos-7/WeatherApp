package com.bemos.weatherapp.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.Location
import com.bemos.weatherapp.presentation.screen.home.items.CityItem
import com.bemos.weatherapp.presentation.screen.home.items.LocationItem
import com.bemos.weatherapp.ui.theme.WeatherAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    listCity: List<Location>,
    onClick: (String) -> Unit,
    cityList: List<String>,
    searchCity: (String) -> Unit,
    onClickCity: (String) -> Unit,
    onLongClick: (Location) -> Unit
) {

    val searchText = remember {
        mutableStateOf("")
    }

    val isActive = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Text(
            text = "Weather",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        SearchBar(
            modifier = Modifier.fillMaxWidth(),

            query = searchText.value,
            onQueryChange = {
                searchText.value = it
                searchCity(it)
            },
            onSearch = {
                searchText.value = it
                searchCity(it)
            },
            placeholder = {
                Text(
                    text = "Search a city"
                )
            },
            active = isActive.value,
            onActiveChange = {
                isActive.value = it
                searchCity("")
            }
        ) {
            LazyColumn {
                items(items = cityList) {
                    CityItem(
                        cityName = it,
                        onClickCity = onClickCity
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            Modifier.fillMaxWidth()
        ) {
            items(items = listCity) {
                LocationItem(
                    location = it,
                    onClick,
                    onLongClick
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
            onClick = {},
            listOf(),
            searchCity = {

            },
            onClickCity = {

            },
            onLongClick = {

            }
        )
    }
}