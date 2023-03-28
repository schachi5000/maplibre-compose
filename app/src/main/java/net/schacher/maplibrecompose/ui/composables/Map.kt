package net.schacher.maplibrecompose.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.WellKnownTileServer
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.maps.MapView

@Composable
fun MapLibreMap(
    modifier: Modifier = Modifier,
    options: Options,
    cameraPosition: CameraPosition? = null
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            Mapbox.getInstance(context, options.accessToken, options.tileServer)
            MapView(context).apply {
                this.getMapAsync { mapboxMap ->
                    mapboxMap.setStyle(options.styleUrl) {
                        cameraPosition?.let {
                            mapboxMap.cameraPosition = it
                        }
                    }
                }
            }
        })
}

data class Options(
    val styleUrl: String,
    val accessToken: String = "",
    val tileServer: WellKnownTileServer = WellKnownTileServer.MapLibre,
)