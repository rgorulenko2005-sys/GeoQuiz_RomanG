package com.example.geoquiz_romang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.geoquiz_romang.ui.theme.GeoQuiz_RomanGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GeoQuiz_RomanGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class Vopros(
    val text: String,
    val correctOtvet: Boolean
)

val voprosi = listOf(
    Vopros("Canberra is the capital of Australia.", true),
    Vopros("The Pacific Ocean is larger than the Atlantic Ocean.", true),
    Vopros("The Suez Canal connects the Red Sea and the Indian Ocean.", false),
    Vopros("The source of the Nile River is in Egypt.", false),
    Vopros("The Amazon River is the longest river in the Americas.", true),
    Vopros("Lake Baikal is the world's oldest and deepest freshwater lake.", true)
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GeoQuiz_RomanGTheme {
        Greeting("Android")
    }
}