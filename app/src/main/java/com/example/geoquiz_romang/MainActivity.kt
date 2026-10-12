package com.example.geoquiz_romang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.geoquiz_romang.ui.theme.GeoQuiz_RomanGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoQuiz_RomanGTheme {
                GeoQuizScreen()
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
fun GeoQuizScreen() {

    var tecVopros by remember { mutableIntStateOf(0) }
    var otvetil by remember { mutableStateOf(false) }
    var correctCount by remember { mutableIntStateOf(0) }
    var showResult by remember { mutableStateOf(false) }

    val question = voprosi[tecVopros]

    fun checkOtvet(otvet: Boolean) {
        if (!otvetil) {
            if (otvet == question.correctOtvet) {
                correctCount++
            }

            otvetil = true

            if (tecVopros == voprosi.lastIndex) {
                showResult = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "GeoQuiz",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = question.text,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        if (!otvetil) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { checkOtvet(true) }
                ) {
                    Text("TRUE")
                }

                Button(
                    onClick = { checkOtvet(false) }
                ) {
                    Text("FALSE")
                }
            }
        }

        if (tecVopros < voprosi.lastIndex) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        tecVopros++
                        otvetil = false
                    }
                ) {
                    Text("NEXT ❯")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GeoQuiz_RomanGTheme {
        GeoQuizScreen()
    }
}