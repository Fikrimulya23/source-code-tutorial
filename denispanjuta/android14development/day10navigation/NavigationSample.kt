package com.fikrimulya.androidtutorial.denispanjuta.android14development.day10navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationSample() {
    val navController = rememberNavController()

    /*
    * Cara mendeklarasikan NavHost dan NavGraph dapat dilakukan dengan berbagai cara,
    * lihat selengkapnya https://developer.android.com/develop/ui/compose/navigation
    * */

    NavHost(navController = navController, startDestination = "firstscreen") {
        composable(route = "firstscreen") {
            FirstScreen(navigateToSecondScreen = { name,age ->
                navController.navigate("secondscreen/$name/$age")
            })

            /*
            * Apabila hanya ada satu fungsi atau parameter pada composable tersebut,
            * maka penulisan code nya dapat dilakukan seperti ini

            * FirstScreen {
            *   navController.navigate("secondscreen")
            * }

            * Jika argument pada fungsi dalam parameter hanya 1 maka dapat ditulis seperti ini
            * sebagai pengganti it

            * FirstScreen(navigateToSecondScreen = {
            *   name ->
            *   navController.navigate("secondscreen/$name")
            * })

            * */

        }
        composable(route = "secondscreen/{name}/{age}") {
            val name = it.arguments?.getString("name") ?: "No Name"
            val age = it.arguments?.getString("age") ?: "0"

            SecondScreen(
                name = name,
                age = age.toInt(),
                navigateToFirstScreen = {
                    navController.navigate("firstscreen")
                }
            )
            /*
            * Bisa juga ditulis seperti ini
            * SecondScreen(name = name) {
            *    navController.navigate("firstscreen")
            * }
            * */

        }
    }
}