package com.fikrimulya.androidtutorial.PhilippLackner.AndroidJetpackCompose


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun TextfieldsButtonsAndShowingSnackbarsExample() {
    var textValue by remember {
        mutableStateOf("")
    }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = textValue,
                onValueChange = {
                    textValue = it
                },
                shape = RoundedCornerShape(8.dp),
                label = {
                    Text(text = "Input Your Name")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        "Hello $textValue"
                    )
                }
            }) {
                Text(text = "Please Greet Me")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextfieldsButtonsAndShowingSnackbarsExamplePreview() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        TextfieldsButtonsAndShowingSnackbarsExample()
    }
}