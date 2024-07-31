package com.bemos.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
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
import com.bemos.shared.R
import com.bemos.shared.colors.LightBlue

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
                        )
                ) {
                    Icon(
                        modifier = Modifier.clickable {
                            onBackClick()
                        },
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "backBtn",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        isMenuVisible = !isMenuVisible
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Preview Location",
                        fontSize = 16.sp,
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(
                            id = R.drawable.baseline_arrow_drop_down_24
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
                            onClick = { onDropDownItemClick(it.city) }
                        )
                    }
                }
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