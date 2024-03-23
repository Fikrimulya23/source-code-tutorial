package com.fikrimulya.unitconverter.JetpackComposeTutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ModifiersTutorial() {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            // .requiredWidth(700.dp)
            .border(5.dp, Color.Magenta)
            .padding(5.dp)
            .border(5.dp, Color.Blue)
            .padding(5.dp)
            .border(5.dp, Color.Red)
            .padding(10.dp)

            // Sebuah parameter modifier bisa digunakan berkali - kali pada satu modifier yang sama

            // 0.5f berarti setengah dari ukuran yang tersisa (bukan ukuran layar)

            // .requiredWidth(700.dp)
            // digunakan untuk memberikan tinggi suatu composable sesuai dengan tinggi yang
            // diberikan. Berbeda dengan height biasa yang jika value yang diberikan melebihi
            // ukuran layar maka ukuran composable tersebut akan menyesuaikan dengan ukuran layar,
            // pada requiredHeight ukurannya akan tetap sebesar itu meskipun melebihi layar  device,
            // hal ini berlaku juga untuk requiedWidth.

    ) {
        Text(text = "Hello", modifier = Modifier
            .border(5.dp, Color.Yellow)
            .padding(5.dp)
            .offset(20.dp, 20.dp)
            .border(10.dp, Color.Black)
            .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "World", modifier = Modifier
            .clickable {
                //
            }
            .padding(8.dp)
        )

        // Spacer digunakan untuk membuat space kosong umumnya digunakan untuk memberikan jarak
        // Selain clickable, ada juga modifier scrollable, draggable dan zoomable

    }
}