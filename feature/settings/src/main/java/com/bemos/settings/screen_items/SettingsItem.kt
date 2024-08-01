package com.bemos.settings.screen_items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.shared.R

@Composable
fun SettingsItem(
    text: String,
    icon: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier.size(20.dp).align(alignment = Alignment.CenterVertically),
            painter = painterResource(
                id = icon
            ),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun SettingsItemsPreview() {
    SettingsItem(
        "something",
        R.drawable.round_arrow_drop_down_24
    )
}