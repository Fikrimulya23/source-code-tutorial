package com.fikrimulya.androidtutorial.denispanjuta.android14development.day9recipeapp


/*
* sealed digunakan ketika sudah diketahui sebelumnya bahwa sebuah tipe akan sesuai dengan salah
* satu tipe sub class

* sealed class memastikan keamanan tipe dengan membatasi tipe yang akan dicocokkan untuk
* menghindari terjadinya kesalahan penulisan

* */

sealed class Screen(val route: String) {
    object RecipeScreen:Screen("recipescreen")
    object DetailRecipeScreen:Screen("detailrecipescreen")
}