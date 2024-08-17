package com.bemos.map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView

@Composable
fun MapContent() {
    var mapView by remember {
        mutableStateOf<MapView?>(null)
    }
    AndroidView(
        factory = { context ->
            MapView(context).apply {
                mapView = this
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)
                minZoomLevel = 10.0
                maxZoomLevel = 30.0
                zoomController.setVisibility(
                    CustomZoomButtonsController.Visibility.NEVER
                )
            }
        }
    )
}

@Preview
@Composable
fun MapContentPreview() {
    MapContent()
}