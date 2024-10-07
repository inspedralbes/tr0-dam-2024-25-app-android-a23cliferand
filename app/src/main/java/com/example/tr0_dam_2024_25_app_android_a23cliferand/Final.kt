package com.example.tr0_dam_2024_25_app_android_a23cliferand

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.sendResponses
import com.example.tr0_dam_2024_25_app_android_a23cliferand.ui.theme.fontFamily
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.JsonParser
import kotlin.system.exitProcess

data class Resultao(val correctes: Int = 0, val incorrectes: Int = 0)

@Composable
fun Final(navController: NavController) {
    val gson = Gson()
    var image: Painter

    //val jsonResponse = gson.toJson(sendResponses("http://192.168.1.134:3000/putRespostes"))

    val correctes = 0
    val incorrectes = 0

    var text = "Resultats"
    if (correctes > incorrectes) {
        image = painterResource(R.drawable.rajoy)
        text = "Has ganao!"
    } else {
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
        Spacer(modifier = Modifier.height(16.dp))


        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)

        )

        Text(
            text = "Correctes: " + correctes,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green,
            fontFamily = fontFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )



        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { navController.navigate("menu") },
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Centra el botón horizontalmente
        ) {
            Text(text = "Reiniciar", fontFamily = fontFamily)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { exitProcess(0)  },
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Centra el botón horizontalmente
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
