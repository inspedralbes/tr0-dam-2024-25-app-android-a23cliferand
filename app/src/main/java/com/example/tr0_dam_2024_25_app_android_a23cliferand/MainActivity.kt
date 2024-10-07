package com.example.tr0_dam_2024_25_app_android_a23cliferand

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.Pregunta
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.getJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

val url = "http://192.168.1.134:3000/getQuestionsAndroid"
var preguntes = emptyList<Pregunta>()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usar una coroutine para realizar operaciones de red
        CoroutineScope(Dispatchers.IO).launch {
            preguntes = getJson(url)
            withContext(Dispatchers.Main) {
                setContent {
                    Myapp()
                }
            }
        }
    }
}

@Composable
fun Myapp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MainMenu(navController)
        }
        composable("questions") {
            Questions(navController, preguntes)
        }
        composable("final") {
            Final(navController)
        }
    }
}