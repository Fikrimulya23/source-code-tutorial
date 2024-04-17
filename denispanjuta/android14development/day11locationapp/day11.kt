package com.fikrimulya.androidtutorial.denispanjuta.android14development.day11locationapp

/*
* LOCATION APP

* Tambahkan permission ke manifest
* <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
* <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>

* ACCESS_COARSE_LOCATION digunakan untuk mendapatkan lokasi kasar dari perangkat,
* menggunakan sinyal tower atau wifi yang terhubung dengan perangkat, ini ti2dak terlalu
* akurat namun tetap berjalan dengan baik ketika ingin mendapatkan gambaran besar lokasi
* (lokasi negara atau lokasi Negara bagian)

* ACCESS_FINE_LOCATION digunakan untuk mendapatkan lokasi perangkat secara lebih detail
* dan akurat menggunakan GPS atau metode pemposision berbasis satelit lainnya

* keduanya memerlukan daya yang berbeda dalam penggunaannya, sehingga cukup digunakan
* sesuai dengan kebutuhannya saja untuk menghindari aplikasi menghabiskan daya secara
* berlebihan.

*
* */