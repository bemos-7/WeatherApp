package com.bemos.settings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.domain.model.LocationDaoDomain
import com.bemos.shared.R
import com.bemos.settings.screen_items.SettingsItem

@Composable
fun SettingsContent(
    onBackClick: () -> Unit,
    dropdownItems: List<LocationDaoDomain>,
    onDropDownItemClick: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    isPreviewEnabled: Boolean
) {
    var isMenuVisible by remember {
        mutableStateOf(false)
    }

    var changePreview by remember(isPreviewEnabled) {
        mutableStateOf(isPreviewEnabled)
    }

    Log.d("changePreview", changePreview.toString())

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
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .clickable {
                            onBackClick()
                        }.align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.round_arrow_back_ios_new_24),
                        contentDescription = "backBtn",
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.settings),
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
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            text = (stringResource(id = R.string.additional_functions)).uppercase(),
                            color = Color.Gray
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.preview_locaiton),
                            fontSize = 16.sp,
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Switch(
                                checked = changePreview,
                            onCheckedChange = {
                                onCheckedChange(it)
                                changePreview = it
                            }
                        )
                    }

                    if (changePreview) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .clickable {
                                    isMenuVisible = !isMenuVisible
                                },
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = stringResource(id = R.string.change_the_location),
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
                        text = (stringResource(id = R.string.about_weatherapp)).uppercase(),
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                SettingsItem(
                    text = stringResource(id = R.string.feedback),
                    icon = R.drawable.round_arrow_forward_ios_24
                )
                Spacer(modifier = Modifier.height(15.dp))
                SettingsItem(
                    text = stringResource(id = R.string.privacy_policy),
                    icon = R.drawable.round_arrow_forward_ios_24
                )
                Spacer(modifier = Modifier.height(15.dp))
                SettingsItem(
                    text = stringResource(id = R.string.credits),
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

        },
        onCheckedChange = {

        },
        true
    )
}