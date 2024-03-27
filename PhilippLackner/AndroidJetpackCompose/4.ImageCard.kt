package com.fikrimulya.androidtutorial.PhilippLackner.AndroidJetpackCompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fikrimulya.androidtutorial.R

// Contoh penggunaan
/*
    val painter = painterResource(id = R.drawable.rock)
    val description = "This is Colorful rock"
    val title = "Colorful rock"
    Box(modifier = Modifier
        .fillMaxWidth(0.5f)
        .padding(16.dp)
    ) {
        ImageCardTutorial2(
            painter = painter,
            contentDescription =description,
            title = title
        )
    }
*/

@Composable
fun ImageCardTutorial2(
    painter: Painter, // image resource
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        // Box merupakan sebuah composable yang mampu menampung 1 atau lebih composable lainnya
        // secara menumpuk / stack, alignment bisa digunakan untuk memberi posisi dari composable
        // yang ada dalam Box
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
                // Brush digunakan untuk memberikan warna gradient
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
            // SP adalah singkatan dari pixel-scale-independent
            // DP adalah pixel-density-independent. SP dan DP sama
            // SP memiliki faktor penskalaan tambahan berdasarkan ukuran teks yang disukai pengguna
            // SP harus digunakan untuk menentukan ukuran teks tetapi tidak untuk ukuran tata letak
        }
    }
}