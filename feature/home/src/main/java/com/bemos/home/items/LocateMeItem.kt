package com.bemos.home.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bemos.shared.R

@Composable
fun LocateMeItem(
    onLocationClick: () -> Unit
) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                onLocationClick()
            },
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                painter = painterResource(
                    id = R.drawable.location_marker
                ),
                contentDescription = "location_marker",
                tint = MaterialTheme.colorScheme.primary
            )

            Text(
                modifier = Modifier.padding(start = 15.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                text = stringResource(id = R.string.locate_me).toUpperCase()
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
    }

    Spacer(modifier = Modifier.height(15.dp))
}