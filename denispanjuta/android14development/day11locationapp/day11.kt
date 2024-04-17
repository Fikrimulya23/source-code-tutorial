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

* Context adalah abstract class yang membantu Activity saat ini untuk memberikan layanan atau
* sumberdaya, contoh Context dapat memberikan akses ke database lokal, ke kelas, service dan
* lain-lain, Jadi context ini seperti penghubung untuk dapat mengakses ke resource atau sumber daya
* aplikasi tertentu

* Context adalah penghubung yang dapat mengijinkan Activity atau Kelas lain agar dapat mengakses
* resource yang kita inginkan di dalam Android

* Tambahkan dependency pada build gradle module app
* implementation("com.google.android.gms:play-services-location:21.2.0")
* */