package com.bemos.home

import android.widget.ProgressBar
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.LocationDaoDomain
import com.bemos.feature.model.LocationWithWeather
import com.bemos.home.items.CityItem
import com.bemos.home.items.LocateMeItem
import com.bemos.home.items.LocationItem
import com.bemos.shared.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    listCity: List<LocationDaoDomain>,
    listLocationsWithWeather: List<LocationWithWeather>,
    onClick: (String) -> Unit,
    cityList: List<String>,
    searchCity: (String) -> Unit,
    onClickCity: (String) -> Unit,
    onLongClick: (LocationDaoDomain) -> Unit,
    onLocationClick: () -> Unit,
    onBurgerClick: () -> Unit
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

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Weather",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        onBurgerClick()
                    },
                painter = painterResource(
                    id = R.drawable.round_dehaze_24
                ),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }

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
                item { 
                    Spacer(modifier = Modifier.height(15.dp))
                }
                item {
                    LocateMeItem(
                        onLocationClick
                    )
                }
                items(items = cityList) {
                    CityItem(
                        cityName = it,
                        onClickCity = onClickCity
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (listLocationsWithWeather.isEmpty()) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                Modifier.fillMaxWidth()
            ) {
                items(items = listLocationsWithWeather) {
                    LocationItem(
                        locationWithWeather = it,
                        onClick,
                        onLongClick
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
//    HomeContent(
//        listCity = listOf(
//            LocationDaoDomain(1, "Moscow"),
//            LocationDaoDomain(2, "London")
//        ),
//        listOf(),
//        onClick = {},
//        listOf(),
//        searchCity = {
//
//        },
//        onClickCity = {
//
//        },
//        onLongClick = {
//
//        },
//        onLocationClick = {
//
//        },
//        onBurgerClick = {
//
//        }
//    )
}