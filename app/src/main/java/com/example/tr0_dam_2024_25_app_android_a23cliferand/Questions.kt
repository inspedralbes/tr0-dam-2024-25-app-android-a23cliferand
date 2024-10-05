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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.tr0_dam_2024_25_app_android_a23cliferand.ui.theme.fontFamily
import kotlin.system.exitProcess


//enum class GameScreen(@StringRes val title: Int) {
    //Menu(title = R.string.app_name),
    //Flavor(title = R.string.choose_flavor),
    //Pickup(title = R.string.choose_pickup_date),
    //Summary(title = R.string.order_summary)
//}

@Composable
fun Questions() {
    val image = painterResource(R.drawable.rajoy)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top, // Alineación superior para que el contenido esté desde arriba
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "TR0 Mola Mazo",
            fontSize = 40.sp, // Tamaño ajustado para caber mejor
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = fontFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Imagen debajo del título
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Botón 1
                Button(onClick = { /* Acción del botón 1 */ }) {
                    Text(text = "Iniciar", fontFamily = fontFamily)
                }

                // Botón 2
                Button(onClick = { /* Acción del botón 2 */ }) {
                    Text(text = "Opción 2", fontFamily = fontFamily)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Botón 3
                Button(onClick = { /* Acción del botón 3 */ }) {
                    Text(text = "Opción 3", fontFamily = fontFamily)
                }

                // Botón 4
                Button(onClick = { /* Acción del botón 4 */ }) {
                    Text(text = "Salir", fontFamily = fontFamily)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RunQuestions() {
    Questions()
}