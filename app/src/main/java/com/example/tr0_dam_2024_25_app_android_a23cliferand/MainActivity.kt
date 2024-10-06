package com.example.tr0_dam_2024_25_app_android_a23cliferand

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tr0_dam_2024_25_app_android_a23cliferand.data.getJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usar una coroutine para realizar operaciones de red
        CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    setContent {
                        MainMenu()
                    }
                }
        }
    }
}