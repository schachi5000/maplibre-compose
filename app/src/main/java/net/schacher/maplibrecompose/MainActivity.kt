package net.schacher.maplibrecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.schacher.maplibrecompose.ui.composables.MapLibreMap
import net.schacher.maplibrecompose.ui.theme.MapLibreComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Composable
fun Content() {
    MapLibreComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MapLibreMap(
                modifier = Modifier.fillMaxSize(),
                styleUrl = BuildConfig.MAP_STYLE_URL
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Content()
}