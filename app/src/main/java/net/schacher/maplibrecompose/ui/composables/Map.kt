package net.schacher.maplibrecompose.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.WellKnownTileServer
import com.mapbox.mapboxsdk.maps.MapView

@Composable
fun MapLibreMap(
    modifier: Modifier = Modifier,
    styleUrl: String
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            Mapbox.getInstance(context, null, WellKnownTileServer.MapLibre)
            MapView(context).apply {
                this.getMapAsync { mapboxMap ->
                    mapboxMap.setStyle(styleUrl) {

                    }
                }
            }
        })
}