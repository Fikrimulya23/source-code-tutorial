package com.fikrimulya.androidtutorial.denispanjuta.android14development.day11locationapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Looper
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import java.util.Locale

class LocationUtils(val context: Context) {

    private val _fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    /*
    * @SuppressLint("MissingPermission") digunakan untuk menghindari MissingPermission pada
    * _fusedLocationClient.requestLocationUpdates(...), fungsi ini memerlukan permission untuk
    * memanggilnya yang mana ada kemungkinan permission tersebut ditolak oleh pengguna sehingga
    * memerlukan pengecekan permission terlebih dahulu menggunakan checkPermission atau
    * secara eksplisit menangani SecurityException.
    *
    * lint tool memeriksa Android project resource file anda untuk mencari potensi bug dan
    * peningkatan pengoptimalan untuk correctness, security, performance, usability, accessibility
    * dan internationalization.
    * Pada Android Studio, konfigurasi lint dan IDE inspections dijalankan ketika build aplikasi.
    * */
    @SuppressLint("MissingPermission")
    fun requestLocationUpdates(viewModel: LocationViewModel) {
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                locationResult.lastLocation?.let {
                    val location = LocationData(latitude = it.latitude, longitude = it.longitude)

                    viewModel.updateLocation(location)
                }
            }
        }

        // Semakin tinggi Priority Accuracy, semakin tinggi juga daya baterai yang digunakan
        val locationRequest =
            LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000).build()

        /*
        * Looper menangani threading dan message processing untuk update lokasi, hal ini
        * memungkinkan location provider untuk berkomunikasi dengan thread main apps atau
        * thread lain yang ditentukan
        * Dengan menyediakan looper tertentu, anda dapat mengontrol kemana thread location
        * update akan dikirimkan
        * */
        _fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper(),
        )
    }

    fun hasLocationPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun reverseGeocodeLocation(location: LocationData): String {
        /*
        * Locale pada kode ini digunakan untuk penulisan dari alamat tersebut
        * Locale.getDefault() berarti penulis alamat berdasarkan bahasa dari device tersebut,
        * namun anda tetap menuliskan Locale nya secara lebih spesifik sesuai Negara yang diinginkan
        * */
        val geocoder = Geocoder(context, Locale.getDefault())
        val coordinate = LatLng(location.latitude, location.longitude)
        /*
        * address yang didapatkan bisa null karena ada kemungkinan alamat dari latlong tersebut
        * tidak diketahui karena berada ditempat yang cukup terpencil. Lokasi yang bisa didapat
        * dari metode ini bisa lebih dari 1, karena itu disini kita membatasi resultnya hanya 1
        * */
        val address: MutableList<Address>? =
            geocoder.getFromLocation(coordinate.latitude, coordinate.longitude, 1)

        return if (address?.isNotEmpty() == true) {
            address[0].getAddressLine(0)
        } else {
            "Address not found"
        }
    }
}