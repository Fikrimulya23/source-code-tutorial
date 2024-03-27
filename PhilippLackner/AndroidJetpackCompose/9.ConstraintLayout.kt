package com.fikrimulya.androidtutorial.PhilippLackner.AndroidJetpackCompose


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

/*
* Dimension option:
* 1. percent
* 2. value
* 3. fillToConstraint

* fillToConstraint membutuhkan batas atau acuan untuk menentukan ukurannya,
* sehingga ketika tinggi suatu constrain menggunakan fillToConstraint maka top dan
* start nya perlu ditentukan terlebih dahulu

* CreateHorizonalChain & CreateVerticalChain mirip seeprti row dan column
* createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Spread)

* Guide line berdasarkan ukuran layar
* val guideLine = createGuidelineFromTop(0.5f)

* */

@Composable
fun ConstraintLayoutExample() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redbox")
        val magentaBox = createRefFor("magentabox")
        val yellowBox = createRefFor("yellowbox")

        // Guide line berdasarkan ukuran layar
        val guideLine = createGuidelineFromTop(0.5f)

        constrain(greenBox) {
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(magentaBox) {
            top.linkTo(greenBox.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(yellowBox) {
            top.linkTo(magentaBox.top)
            start.linkTo(magentaBox.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
    }

    ConstraintLayout(
        constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
                .background(Color.Green)
                .layoutId("greenbox")
        )
        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("redbox")
        )
        Box(modifier = Modifier
            .background(Color.Magenta)
            .layoutId("magentabox")
        )
        Box(modifier = Modifier
            .background(Color.Yellow)
            .layoutId("yellowbox")
        )
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