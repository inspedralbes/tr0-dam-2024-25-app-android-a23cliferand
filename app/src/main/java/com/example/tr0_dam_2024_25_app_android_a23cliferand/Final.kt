package com.example.tr0_dam_2024_25_app_android_a23cliferand

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.sendResponses
import com.example.tr0_dam_2024_25_app_android_a23cliferand.ui.theme.fontFamily
import com.google.gson.Gson
import kotlin.system.exitProcess

data class Resultao(val correctes: Int = 0, val incorrectes: Int = 0)

@Composable
fun Final(navController: NavController) {
    val gson = Gson()
    var image: Painter = painterResource(R.drawable.rajoy)
    var correctes by remember { mutableStateOf(0) }
    var incorrectes by remember { mutableStateOf(0) }
    var hasSentResponses by remember { mutableStateOf(false) }

    LaunchedEffect(hasSentResponses) {
        if (!hasSentResponses) {
            hasSentResponses = true
            Log.d("Final", "Sending responses")
            val jsonResponse = sendResponses("http://a23cliferand.dam.inspedralbes.cat:26969/putRespostes")
            //println(getGrafics())
            val resultao = gson.fromJson(jsonResponse, Resultao::class.java)
            correctes = resultao.correctes
            incorrectes = resultao.incorrectes
        }
    }

    var text = "Resultats"
    if (correctes >= incorrectes) {
        image = painterResource(R.drawable.rajoy)
        text = "Has ganao!"
    } else if ((correctes < incorrectes)) {
        image = painterResource(R.drawable.sanchez)
        text = "Has perdio!"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = fontFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )

        Text(
            text = "Correctes: $correctes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green,
            fontFamily = fontFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Incorrectes: $incorrectes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontFamily = fontFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                hasSentResponses = true
                navController.navigate("menu")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Reiniciar", fontFamily = fontFamily)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { exitProcess(0) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Sortir", fontFamily = fontFamily)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RunFinal() {
        Final(navController = rememberNavController())
    }
