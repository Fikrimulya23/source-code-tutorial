package com.fikrimulya.androidtutorial.PhilippLackner.AndroidJetpackCompose


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun ConstraintLayoutExample() {
    val constraint = ConstraintSet {}
    ConstraintLayout {

    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutExamplePreview() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        ConstraintLayoutExample()
    }
}