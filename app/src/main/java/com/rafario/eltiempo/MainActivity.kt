package com.rafario.eltiempo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.rafario.eltiempo.ui.theme.ElTiempoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ElTiempoTheme {
                Scaffold(bottomBar = {
                    BottomAppBar {
                        Icon(Icons.Default.Edit, "", modifier = Modifier.weight(1f))
                        Icon(Icons.Default.Edit, "", modifier = Modifier.weight(1f))
                    }
                }) { innerPadding ->
                    MapApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MapApp(modifier: Modifier = Modifier) {
    var permissionGranted by remember { mutableStateOf<Boolean?>(null) }
    var location by remember { mutableStateOf<LatLng?>(null) }

    val context = LocalContext.current
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        permissionGranted = granted
        if (granted) {
            obtainCurrentLocation(context, fusedLocationClient) {
                location = it
            }
        }
    }

    when (permissionGranted) {
        null -> {
            SplashScreen {
                requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }

        true -> {
            MapScreen(location, true, modifier, context)
        }

        false -> {
            MapScreen(null, false, modifier, context)
        }
    }
}

@Composable
fun SplashScreen(onRequestLocationPermission: () -> Unit) {

    LaunchedEffect(Unit) {
        onRequestLocationPermission()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

    }
}

fun obtainCurrentLocation(
    context: Context,
    fusedLocationClient: FusedLocationProviderClient,
    onLocationReceived: (LatLng) -> Unit
) {
    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED &&
        ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        return
    }

    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        location?.let {
            onLocationReceived(LatLng(it.latitude, it.longitude))
        }
    }
}

@Composable
fun MapScreen(initialLocation: LatLng?, isPermissionGranted: Boolean, modifier: Modifier, context: Context) {
    var coordinates by remember { mutableStateOf<LatLng?>(null) }
    val camaraState = rememberCameraPositionState()
    val darkTheme = isSystemInDarkTheme()

    val mapStyleOptions = remember {
        if (darkTheme) {
            MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style_dark)
        } else {
            null
        }
    }

    LaunchedEffect(initialLocation) {
        if (initialLocation != null) {
            camaraState.animate(
                update = CameraUpdateFactory.newLatLngZoom(initialLocation, 15f),
                durationMs = 1000
            )
        }
    }

    Column(modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.weight(1f),
            cameraPositionState = camaraState,
            properties = MapProperties(
                isMyLocationEnabled = isPermissionGranted,
                mapStyleOptions = mapStyleOptions
            ),
            onMapClick = { latLng ->
                coordinates = latLng
            }
        ) {
            coordinates?.let {
                Marker(
                    state = MarkerState(position = it),
                    title = "Seleccionado"
                )
            }
        }

        Text(
            text = coordinates?.let { "Lat: ${it.latitude}, Lng: ${it.longitude}" }
                ?: if (isPermissionGranted) "Seleccione coordenadas" else "Permiso de ubicacion mal",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun InfoBottomSheet(modifier: Modifier = Modifier) {

}