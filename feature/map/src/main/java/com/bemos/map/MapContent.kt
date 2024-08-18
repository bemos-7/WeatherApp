package com.bemos.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bemos.map.utils.CustomMap
import com.bemos.shared.R
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

@Composable
fun MapContent(
    mapView: MapView,
    onUserGeoPointClick: () -> Unit
) {
    Box(
        Modifier.fillMaxSize()
    ) {
        CustomMap(
            mapView,
            mapSettings = {
                val startPoint = GeoPoint(42.0, 49.0)
                it.controller.setCenter(startPoint)
            }
        )

        Button(
            onClick = {
                onUserGeoPointClick()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_boy_24),
                contentDescription = null
            )
        }
    }

}

@Preview
@Composable
fun MapContentPreview() {
//    MapContent(
//
//        onUserGeoPointClick = {}
//    )
}