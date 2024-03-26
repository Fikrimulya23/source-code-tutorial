package com.fikrimulya.androidtutorial.PhilippLackner.AndroidJetpackCompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
* Scrollable Column menampilkan semua item ketika column tersebut ditampilkan, berbeda dengan
* Lazy Colum yang hanya menampilkan item ketika posisi atau index nya sudah sampai pada item
* tersebut. Hal ini dapat meningkatkan performa dan mengurangi penggunaan memori aplikasi.
* */

@Composable
fun ListExample() {
    MyLazyColumn()
    // MyScrollableColumn()
}

@Composable
fun MyLazyColumn() {
    LazyColumn {
        /*
        * Item digunakan pada simple item yang bisa kita deklarasikan satu persatu
        * Items dapat digunakan untuk membuat item dengan index
        * */

        // Contoh items
        /*items(1000) {
            Text(
                text = "Item number $it",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp)
            )
        }*/

        itemsIndexed(
            listOf("This", "is", "Jetpack", "Compose")
        ) { index, item ->
            Text(
                text = item,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp)
            )
        }
    }
}

@Composable
fun MyScrollableColumn() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for(i in 1..50) {
            Text(
                text = "Item number $i",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListExamplePreview() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        ListExample()
    }
}