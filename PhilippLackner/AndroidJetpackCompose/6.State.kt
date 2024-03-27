package com.fikrimulya.androidtutorial.PhilippLackner.AndroidJetpackCompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random


/*
*
* */
@Composable
fun StateExample() {
    Column(
      modifier = Modifier.fillMaxSize()
    ) {
        var color = remember {
            mutableStateOf(Color.Yellow)
        }

        ColorBox(modifier = Modifier
            .weight(1f)
            .fillMaxSize()
        ) {
            color.value = it;
        }

        Box(modifier = Modifier
            .background(color.value)
            .weight(1f)
            .fillMaxSize()
        )

        /*
        * weight(1f) memberikan ukuran pada kedua box dengan ukuran yang sama
        * yaitu 1f
        * */

        /*
        * Lambda Function merupakan sebuah fungsi yang tidak memiliki nama
        * Pada contoh dibawah updateColor memiliki parameter Color dan return Unit yang berarti
        * tidak memiliki return value
        *
        * updateColor mengubah warna pada clickable, setelah itu nilai tersebut dimasukkan
        * ke dalam variabel color.value
        * */
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit // lambda function
) {
    Box(
        modifier = modifier
            .background(color = Color.Red)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    )
}

@Preview(showBackground = true)
@Composable
fun StateExamplePreview() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        StateExample()
    }
}