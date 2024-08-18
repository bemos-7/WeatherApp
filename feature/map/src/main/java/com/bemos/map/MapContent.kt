package com.bemos.map

import android.view.MotionEvent
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
    var map by remember {
        mutableStateOf(mapView)
    }
    var context = LocalContext.current

    val mapV = remember {
        MapView(context)
    }
    Box(
        Modifier.fillMaxSize()
    ) {
        var currentMarker: Marker? by remember {
            mutableStateOf(null)
        }
        CustomMap(
            mapV,
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

        if (currentMarker != null) {
            Button(
                modifier = Modifier.padding(top = 50.dp),
                onClick = {
                    onMapClick(
                        "${currentMarker!!.position.latitude},${currentMarker!!.position.longitude}"
                    )
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_boy_24),
                    contentDescription = null
                )
            }
        }

        DisposableEffect(Unit) {
            onDispose {
                mapView.onDetach()
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