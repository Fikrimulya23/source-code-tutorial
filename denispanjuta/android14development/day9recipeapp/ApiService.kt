package com.fikrimulya.androidtutorial.denispanjuta.android14development.day9recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/*
* suspend kemungkinan memerlukan waktu lebih lama daripada biasanya untuk menampilkan data pada UI,
* tergantung pada banyak faktor seperti kecepatan internet, ukuran data dan sebagainya.
* Operasi semacam ini diproses secara asynchronous, yang berarti bawah operasi tersebut terjadi di
* background, sehingga dapat dikatakan untuk menghindari kebosanan pengguna selama waktu tunggu.
* Dan disinilah keyword suspend berperan.

* Ini adalah bagian dari API coroutine yang menyediakan cara langsung dan terstruktur untuk
* mengelola konkurensi (beberapa proses yang berjalan diwaktu yang sama).
* Untuk mencegah aplikasi freeze ketika proses ini terjadi, disinilah kita menggunakan suspend yang
* memungkinkan kita menjalankan perhitungan atau eksekusi kode yang memakan waktu lama seperti
* memuat data, karena kita tidak tahu berapa lama waktu yang dibutuhkan.

* Coroutine adalah kerangka kerja konkurensi yang kuat dan ringan di kotlin, yang secara khusus
* dirancang untuk menangani operasi pemblokiran asynchronous dan non-blocking. Membaca maupun
* menulis ke database atau menangani operasi yang memakan waktu tanpa memblokir main thread
* yaitu UI thread.

* suspend pada fungsi getCategories akan memproses fungsi ini dibackground, menjaga interface tetap
* responsif sampai data diambil.
* */

private val retrofit = Retrofit.Builder()
    .baseUrl("www.themealdb.com/api/json/v1/1")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {
    /*
    * keyword @Get digunakan untuk menentukan jenis permintaan yang harus dibuat ke URL tertentu
    * "categories.php" sebagai end point
    * */
    @GET("categories.php")
    suspend fun getCategories():CategoryResponse
}