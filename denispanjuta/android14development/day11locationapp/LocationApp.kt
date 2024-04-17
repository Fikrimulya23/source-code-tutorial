package com.fikrimulya.androidtutorial.denispanjuta.android14development.day11locationapp

import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.fikrimulya.androidtutorial.MainActivity

/*
* Deklarasikan viewModel untuk kemudian dimasukkan ke parameter viewModel yang ada pada locationApp
*  setContent {
            val viewModel: LocationViewModel = viewModel()
* */

@Composable
fun LocationApp(viewModel: LocationViewModel) {
    val context = LocalContext.current
    val locationUtils = LocationUtils(context)
    locationDisplay(locationUtils = locationUtils, viewModel = viewModel, context = context)
}

@Composable
fun locationDisplay(
    locationUtils: LocationUtils,
    viewModel: LocationViewModel,
    context: Context
) {
    val location = viewModel.location.value
    val address =  location?.let {
        locationUtils.reverseGeocodeLocation(location)
    }

    /*
    * Memunculkan Activity dalam bentuk popup untuk meminta permission melalui contract dan
    * mengelola hasilnya pada onResult
    * */
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions ->
            // permissions berisi hasil dari list permissions yang diminta
            if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
            ) {
                locationUtils.requestLocationUpdates(viewModel = viewModel)
            } else {
                // menampilkan 'kenapa kita membutuhkan lokasi tersebut' kepada pengguna
                val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    // tidak memerlukan as MainActivity karena sudah dilakukan pada line sebelumnya
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )

                if (rationaleRequired) {
                    /*
                    * ditampilkan ketika pengguna pertama kali menolak memberikan permission
                    * atau pengguna membatalkan untuk memberi permission (back button)
                    * */
                    Toast.makeText(
                        context, "We need to access your location for this feature",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    /*
                    * ditampilkan ketika pengguna menolak memberikan permission untuk yang kedua
                    * kalinya atau pengguna menolak memberikan permission melalui android settings
                    * */
                    Toast.makeText(
                        context,
                        "We need to access your location, please enable it in Android Settings",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        },
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        if (location != null) {
            Text(text = "${location.latitude} ${location.longitude}\n$address")
        } else {
            Text(text = "Location not available")
        }
        Button(onClick = {
            if (locationUtils.hasLocationPermission(context)) {
                locationUtils.requestLocationUpdates(viewModel)
            } else {
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }) {
            Text(text = "Get Location")
        }
    }
}