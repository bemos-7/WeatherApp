package com.bemos.map

import android.view.MotionEvent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bemos.map.utils.CustomMap
import com.bemos.shared.R
import org.osmdroid.events.MapEventsReceiver
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Overlay

@Composable
fun MapContent(
    mapView: MapView,
    onUserGeoPointClick: () -> Unit,
    onMapClick: (String) -> Unit
) {
    Box(
        Modifier.fillMaxSize()
    ) {
        var currentMarker: Marker? by remember {
            mutableStateOf(null)
        }
        CustomMap(
            mapView,
            mapSettings = {
                it.overlays.add(object : Overlay() {
                    override fun onSingleTapUp(e: MotionEvent?, mapView: MapView?): Boolean {
                        val geoPoint = mapView?.projection?.fromPixels(e!!.x.toInt(), e.y.toInt()) as GeoPoint

                        if (currentMarker == null) {
                            currentMarker = Marker(it).apply {
                                setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                                it.overlays.add(this)
                            }
                        }
                        currentMarker?.position = geoPoint
                        it.invalidate()

                        return true
                    }
                })
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    end = 10.dp,
                    bottom = 10.dp
                ),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            if (currentMarker != null) {
                OutlinedButton(
                    modifier = Modifier.size(64.dp),
                    onClick = {
                        onMapClick(
                            "${currentMarker!!.position.latitude},${currentMarker!!.position.longitude}"
                        )
                    },
                    shape = CircleShape,
                    border = null,
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.filledTonalButtonColors(
                        contentColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.round_check_24),
                        contentDescription = null
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(10.dp))
            
            OutlinedButton(
                modifier = Modifier.size(64.dp),
                onClick = {
                    onUserGeoPointClick()
                },
                shape = CircleShape,
                border = null,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.filledTonalButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.baseline_navigation),
                    contentDescription = null
                )
            }
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