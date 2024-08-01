package com.bemos.settings

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
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.Location
import com.bemos.settings.screen_items.SettingsItem
import com.bemos.shared.R

@Composable
fun SettingsContent(
    onBackClick: () -> Unit,
    dropdownItems: List<Location>,
    onDropDownItemClick: (String) -> Unit
) {
    var isMenuVisible by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Card(
                modifier = Modifier.padding(10.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            10.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier.clickable {
                            onBackClick()
                        },
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "backBtn",
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Settings",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.size(24.dp))
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {

            Column() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable {
                            isMenuVisible = !isMenuVisible
                        }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            text = ("Additional functions").uppercase(),
                            color = Color.Gray
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Preview location",
                            fontSize = 16.sp,
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(
                                id = R.drawable.round_arrow_drop_down_24
                            ),
                            contentDescription = null
                        )
                    }

                    DropdownMenu(
                        expanded = isMenuVisible,
                        onDismissRequest = {
                            isMenuVisible = false
                        },
                    ) {
                        dropdownItems.forEach {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = it.city
                                    )
                                },
                                onClick = {
                                    onDropDownItemClick(it.city)
                                    isMenuVisible = !isMenuVisible
                                }
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .background(Color.Gray)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = ("ABOUT WEATHERAPP").uppercase(),
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                SettingsItem(
                    text = "Feedback",
                    icon = R.drawable.round_arrow_forward_ios_24
                )
                Spacer(modifier = Modifier.height(15.dp))
                SettingsItem(
                    text = "Privacy policy",
                    icon = R.drawable.round_arrow_forward_ios_24
                )
                Spacer(modifier = Modifier.height(15.dp))
                SettingsItem(
                    text = "Credits",
                    icon = R.drawable.round_arrow_forward_ios_24
                )
            }
        }
    }
}

@Preview
@Composable
fun SettingsContentPreview() {
    SettingsContent(
        onBackClick = {

        },
        dropdownItems = listOf(

        ),
        onDropDownItemClick = {

        }
    )
}