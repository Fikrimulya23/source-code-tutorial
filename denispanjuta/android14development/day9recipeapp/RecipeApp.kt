package com.fikrimulya.androidtutorial.denispanjuta.android14development.day9recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewState = viewState, navigateToDetail = {
                /*
                * Bagian ini bertanggung jawab untuk meneruskan data dari layar saat ini
                * ke DetailRecipeScreen

                * currentBackStackEntry mengambil backstack entry navigation saat ini yang mewakili
                * screen state saat ini dalam navigation graph
                * currentBackStackEntry berfungsi menyimpan flow didalam backstack entry navigation

                * savedStateHandle adalah mekanisme untuk meneruskan data diantara layar yang
                * berbeda menggunakan navigasi jetpack compose, ini menyediakan cara untuk menyimpan
                * dan mengambil data yang perlu diteruskan ke layar berikutnya
                *
                * method set menetapkan sebuah key value dalam savedStateHandle
                * */
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.DetailRecipeScreen.route)
            })
        }
        composable(route = Screen.DetailRecipeScreen.route) {
            /*
            * previousBackStackEntry?.savedStateHandle? mengakses backStackEntry pada
            * currentBackStackEntry dengan kata lain mengakses savedStateHandle halamam sebelumnya
            * */
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?:
                Category("", "", "", "")
            
            CategoryDetailScreen(category = category)
        }
    }
}