package com.example.eatery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.eatery.presentation.theme.EateryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EateryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Brian")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text("Someone is coming $name")
        Text("Another text from Kotlin compose")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EateryTheme {
        Greeting("From else where")
    }
}