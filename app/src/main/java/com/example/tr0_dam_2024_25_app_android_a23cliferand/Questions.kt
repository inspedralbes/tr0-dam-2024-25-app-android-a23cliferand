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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.Pregunta
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.Resposta
import com.example.tr0_dam_2024_25_app_android_a23cliferand.ui.theme.fontFamily
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay


data class RespuestaSeleccionada(val preguntaID: String, val respostaID: Int)
val respuestasSeleccionadas = mutableListOf<RespuestaSeleccionada>()




@Composable
fun Questions(navController: NavController, preguntas: List<Pregunta>) {
    var preguntaActualIndex by remember { mutableStateOf(0) }
    var tiempo by remember { mutableStateOf(false) }
    var remainingTime by remember { mutableStateOf(30) }
    var hasNavigated by remember { mutableStateOf(false) }

    // LaunchedEffect to start the timer
    LaunchedEffect(Unit) {
        while (remainingTime > 0) {
            delay(1000L)
            remainingTime--
        }
        tiempo = true
    }

    if (!tiempo) {
        val pregunta = preguntas[preguntaActualIndex]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$remainingTime segundos",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontFamily = fontFamily,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = pregunta.pregunta,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = fontFamily,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = rememberAsyncImagePainter(model = pregunta.imatge),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                pregunta.respostes.forEach { resposta ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .height(40.dp)
                            .background(Color.LightGray)
                            .clickable {
                                respuestasSeleccionadas.add(
                                    RespuestaSeleccionada(
                                        pregunta.id,
                                        resposta.id
                                    )
                                )
                                println(respuestasSeleccionadas)

                                val siguientePregunta = preguntaActualIndex + 1
                                if (siguientePregunta < preguntas.size) {
                                    preguntaActualIndex = siguientePregunta
                                } else if (!hasNavigated) {
                                    hasNavigated = true
                                    navController.navigate("final")
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = resposta.resposta, fontFamily = fontFamily)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    } else if (!hasNavigated) {
        hasNavigated = true
        for (i in preguntaActualIndex until preguntas.size) {
            respuestasSeleccionadas.add(RespuestaSeleccionada(preguntas[i].id, 0))
        }
        navController.navigate("final")
    }
}

@Preview
@Composable
fun RunQuestions() {
    val samplePregunta = listOf(
        Pregunta(
            id = "1",
            pregunta = "Sample Question",
            respostes = listOf(
                Resposta(id = 1, resposta = "Option 1"),
                Resposta(id = 2, resposta = "Option 2"),
                Resposta(id = 3, resposta = "Option 3"),
                Resposta(id = 4, resposta = "Option 4")
            ),
            imatge = null,
            text = null
        )
    )
    Questions(navController = rememberNavController(), samplePregunta)
}