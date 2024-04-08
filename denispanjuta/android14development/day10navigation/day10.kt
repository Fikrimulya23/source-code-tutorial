package com.fikrimulya.androidtutorial.denispanjuta.android14development.day10navigation

/*
* NAVIGATION
* Tambahkan dependency pada build.gradle module app

* dependencies {
*     val nav_version = "2.7.7"
*     implementation("androidx.navigation:navigation-compose:$nav_version")
* }

* navController adalah API pusat untuk navigation component
* bersifat stateful dan melacak stack / tumpukan composable (Backstack Composable) yang membentuk
* screen pada aplikasi dan juga state pada tiap screen.

* Backstack adalah tumpukan dari screen yang menyimpan riwayat dari screen yang telah dikunjungi,
* sehingga ketika pengguna menekan tombol back, maka aplikasi akan kembali ke screen sebelumnya.

* first screen -> second screen -> third screen
* back
* first screen -> second screen


* NavHost
* NavHost memerlukan navController dan NavGraph
* NavHost adalah sebuah container kosong di dalam layout aplikasi yang menangani pertukaran tujuan navigasi

* NavHost bertanggung jawab untuk menampilkan tujuan-tujuan (destinations) yang didefinisikan dalam
* NavGraph dan mengelola transisi antara mereka.

* Saat aplikasi menavigasi dari satu tujuan ke tujuan lainnya, NavHost akan menangani pembuangan
* tujuan lama dan menampilkan tujuan yang baru (kita biasa menyebutnya dengan stack).

* NavGraph
* Memetakan alur navigasi dan halaman dalam sebuah aplikasi. Terdiri dari destination dan route.
* Destination: halaman tujuan yang bisa diakses. Setiap aplikasi harus memiliki start destination
* yang merupakan halaman awal ketika aplikasi dibuka.

* Route: menentukan jalur yang mungkin untuk dinavigasi pada setiap halaman.
* Route ditentukan menggunakan path berupa String layaknya URL.

* NavController
* NavController adalah objek yang bertanggung jawab untuk memfasilitasi navigasi antara tujuan-tujuan dalam aplikasi.
* Ini adalah pintu gerbang utama untuk berinteraksi dengan sistem navigasi. Dengan NavController,
* Kamu dapat berpindah ke tujuan baru, melakukan pop atau kembali ke tujuan sebelumnya,
* serta menangani berbagai operasi navigasi lainnya.


* Passing data to another screen

* Composable pengirim data
* fun FirstScreen(navigateToSecondScreen: (String)->Unit) {
*    ...
*    navigateToSecondScreen(name.value)
*    ...
* }

* Composable penerima data
* fun SecondScreen(name:String, navigateToFirstScreen:() {}

* it.arguments bisa berisi lebih dari 1 data, sehingga untuk mendapatkan value nya kita memerlukan
* getString(key) untuk mendapat value dari key tersebut.
* it.arguments juga bersifat nullable sehingga memerlukan ?. saat menggunakannya

* argument name berasal dari parameter yang ada pada route

* composable(route = "secondscreen/{name}") {
*     val name = it.arguments?.getString("name") ?: "No Name"
*     SecondScreen(
*         name = name,
*         navigateToFirstScreen = {
*             navController.navigate("firstscreen")
*         }
*     )
* }

* Nilainya didapat dari parameter yang ditambahkan pada route halaman sebelumnya

* FirstScreen(navigateToSecondScreen = {
*     name ->
*     navController.navigate("secondscreen/$name")
* })

* Serialization and Deserialization with Parcelable
* Tambahkan plugins id("kotlin-parcelize") pada build.gradle.kts (Module :app)
* Tambahkan @Parcelize dan Parcelable pada data class Category

* Serialization mengubah data ke bentuk yang sesuai untuk perjalanan
* Deserialization mengubah data setelah sampai tujuan kembali ke bentuk semulanya
* Parcelize yang menangani Serialization dan Deserialization
* Ini memastikan kecepatan dan keamanan pertukaran data
* Objek diserialisasikan ke dalam format yang sesuai untuk penyimpanan atau transmisi, dan kemudian
* diserialisasikan kembali ke bentuk aslinya

* Pada dasarnya Serialization mengubah sebuah objek menjadi String, semua informasi dimasukkan
* kedalam format sehingga sebuah objek menjadi sebuah String.
* Dan ketika melakukan Deserialization, Parcalable tersebut dikembalikan menjadi sebuah objek
* Konsep ini sangat penting ketika anda ingin mengoper tipe data yang kompleks seperti class
* atau objek

* @Parcelize
* data class Category( ... ) : Parcelable

* */