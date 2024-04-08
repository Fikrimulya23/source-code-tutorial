package com.fikrimulya.androidtutorial.denispanjuta.android14development.day9recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewState: MainViewModel.RecipeState,
    navigateToDetail: (Category) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.isLoading -> {
                CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(text = "Error!")
            }

            else -> {
                CategoryScreen(categories = viewState.list, navigateToDetail)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>, navigateToDetail: (Category) -> Unit) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories) { category ->
            CategoryItem(category = category, navigateToDetail)
        }
    }
}

@Composable
fun CategoryItem(category: Category, navigateToDetail: (Category) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {
                navigateToDetail(category)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            /*
            * rememberAsyncImagePainter
            * mengambil gambar secara asynchronous dari internet dan mengembalikan
            * asynchronousImagePainter
            * */
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
            contentDescription = "Category Image",
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(
            text = category.strCategory,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.padding(top = 4.dp),
        )
    }
}