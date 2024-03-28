package com.fikrimulya.androidtutorial.denispanjuta.android14development.day9recipeapp

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

data class CategoryResponse(val categories: List<Category>)