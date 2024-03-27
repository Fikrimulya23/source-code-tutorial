package com.fikrimulya.androidtutorial.PhilippLackner.AndroidJetpackCompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fikrimulya.androidtutorial.R

@Composable
fun StylingTextExample() {
    val fontFamily = FontFamily(
        Font(R.font.lexend_thin, FontWeight.Thin),
        Font(R.font.lexend_light, FontWeight.Light),
        Font(R.font.lexend_regular, FontWeight.Normal),
        Font(R.font.lexend_medium, FontWeight.Medium),
        Font(R.font.lexend_semi_bold, FontWeight.SemiBold),
        Font(R.font.lexend_bold, FontWeight.Bold),
        Font(R.font.lexend_extra_bold, FontWeight.ExtraBold),
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0XFF101010))
        .padding(16.dp)
    ) {
        Text(
            // text = "Jetpack Compose",

            /*
            * Annotated String pada text digunakan untuk membuat text yang mempunyai style yang
            * berbeda - beda.
            * */
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp
                    )
                ) {
                   append("J") // text style mengikuti parent withStyle
                }
                append("etpack ") // text style mengikuti parent
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = 50.sp
                    )
                ) {
                    append("C") // text style mengikuti parent withStyle
                }
                append("ompose") // text style mengikuti parent
            },
            modifier = Modifier.clickable {  },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }

    /*
    * Untuk menambahkan font
    * Pada folder res
    * Klik new -> android resource directory
    * ubah resource type menjadi font -> ok
    * paste font tersebut ke dalam folder font
    * */

    /*
    * Pada satu font umumnya terdapat beberapa font serupa dengan fontweight yang berbeda - beda
    * */
}

@Preview(showBackground = true)
@Composable
fun StylingTextPreview() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        StylingTextExample()
    }
}