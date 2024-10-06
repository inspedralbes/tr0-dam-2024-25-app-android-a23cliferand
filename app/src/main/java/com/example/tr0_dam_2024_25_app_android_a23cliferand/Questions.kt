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
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.Pregunta
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.Resposta
import com.example.tr0_dam_2024_25_app_android_a23cliferand.ui.theme.fontFamily
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

val respuestasSeleccionadas = mutableListOf<Pair<String, Int>>()

@Composable
fun Questions(preguntas: List<Pregunta>) {
    println("Questions function started with ${preguntas.size} questions")

    var preguntaActualIndex by remember { mutableStateOf(0) }
    var mostrarFinal by remember { mutableStateOf(false) }

    if (mostrarFinal) {
        MainMenu()
        return
    }
//Guardamos to

            val pregunta = preguntas[preguntaActualIndex]

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = pregunta.pregunta,
                    fontSize = 40.sp,
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
                    modifier = Modifier
                        .size(250.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    pregunta.respostes.chunked(2).forEach { rowRespostes ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                8.dp,
                                Alignment.CenterHorizontally
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            rowRespostes.forEach { resposta ->
                                Button(
                                    onClick = {
                                        // Guardar el id de la pregunta y la respuesta en un arraylist
                                        respuestasSeleccionadas.add(Pair(pregunta.id, resposta.id))
                                        println(respuestasSeleccionadas)

                                        val siguientePregunta = preguntaActualIndex + 1
                                        if (siguientePregunta < preguntas.size) {
                                            preguntaActualIndex = siguientePregunta
                                        } else {
                                            mostrarFinal = true
                                        }
                                    },
                                    modifier = Modifier.size(100.dp)
                                ) {
                                    Text(text = resposta.resposta, fontFamily = fontFamily)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
@Preview(showBackground = true)
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
    Questions(samplePregunta)
}