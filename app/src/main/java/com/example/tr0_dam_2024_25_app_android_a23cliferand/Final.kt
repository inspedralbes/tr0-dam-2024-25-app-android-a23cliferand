package com.example.tr0_dam_2024_25_app_android_a23cliferand

import androidx.annotation.StringRes
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.tr0_dam_2024_25_app_android_a23cliferand.ui.theme.fontFamily
import kotlin.system.exitProcess

@Composable
fun Final() {
    val image = painterResource(R.drawable.rajoy)

    println("Final function" +  respuestasSeleccionadas.toString())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        Text(
            text = "TR0 Mola Mazo",
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


        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { //exitProcess(0) // Cierra la aplicación
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Centra el botón horizontalmente
        ) {
            Text(text = "Iniciar", fontFamily = fontFamily)
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
        Final()
    }
