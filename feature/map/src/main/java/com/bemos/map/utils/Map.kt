package com.bemos.map.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView

@Composable
fun CustomMap(
    mapView: MapView,
    mapSettings: (MapView) -> Unit,
) {
//    var mapView by remember {
//        mutableStateOf<MapView?>(null)
//    }

//    AndroidView(
//        factory = { context ->
//            MapView(context).apply {
//                mapView = this
//                setTileSource(TileSourceFactory.MAPNIK)
//                setMultiTouchControls(true)
//                minZoomLevel = 9.0
//                maxZoomLevel = 20.0
//                zoomController.setVisibility(
//                    CustomZoomButtonsController.Visibility.NEVER
//                )
//                mapSettings(this)
//            }
//        }
//    )

    AndroidView(factory = { mapView }) {
        it.apply {
            setTileSource(TileSourceFactory.MAPNIK)
            setMultiTouchControls(true)
            minZoomLevel = 9.0
            maxZoomLevel = 20.0
            zoomController.setVisibility(
                CustomZoomButtonsController.Visibility.NEVER
            )
            mapSettings(this)
        }
    }
}