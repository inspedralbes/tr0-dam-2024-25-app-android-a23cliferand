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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.Pregunta
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.getJson
import com.example.tr0_dam_2024_25_app_android_a23cliferand.ui.theme.fontFamily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.exitProcess

// Obtener preguntas del servidor


@Composable
fun MainMenu() {
    var startGame by remember { mutableStateOf(false) }
    var loadedQuestions by remember { mutableStateOf<List<Pregunta>?>(null) }

    if (startGame) {
        if (loadedQuestions == null || loadedQuestions!!.isEmpty()) {
            println("No hi ha preguntes")
            return
        } else {
            Questions(loadedQuestions!!)
        }
    } else {
        val image = painterResource(R.drawable.rajoy)

//    if (startGame) {
//        if (preguntes == null || preguntes.isEmpty()) {
//            println("No hi ha preguntes")
//            return
//        }
//        else{
//        Questions(preguntes)
//        }
//    } else {

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
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val url = "http://192.168.1.137:3000/getQuestionsAndroid"
                            val preguntes = getJson(url)
                            withContext(Dispatchers.Main) {
                                // Update state to trigger recomposition
                                startGame = true
                                loadedQuestions = preguntes
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Iniciar", fontFamily = fontFamily)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { exitProcess(0) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Sortir", fontFamily = fontFamily)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RunMainMenu() {
        MainMenu()
    }
