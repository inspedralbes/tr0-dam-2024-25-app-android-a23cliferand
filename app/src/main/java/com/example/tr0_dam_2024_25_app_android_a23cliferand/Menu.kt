/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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



enum class GameScreen(@StringRes val title: Int) {
    Menu(title = R.string.app_name),
    //Flavor(title = R.string.choose_flavor),
    //Pickup(title = R.string.choose_pickup_date),
    //Summary(title = R.string.order_summary)
}


@Composable
fun MainMenu() {
    // Contenedor principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título del menú
        Text(
            text = "Menú Principal",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally) // Centra el texto horizontalmente
        )

        // Espaciador
        Spacer(modifier = Modifier.height(100.dp))

        // Primer botón
        Button(
            onClick = { /* Acción del botón 1 */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Centra el botón horizontalmente
                .padding(top = 0.dp) // Espaciado superior (puedes modificarlo)
        ) {
            Text(text = "Botón 1")
        }

        // Espaciador entre botones
        Spacer(modifier = Modifier.height(16.dp))

        // Segundo botón
        Button(
            onClick = { /* Acción del botón 2 */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Centra el botón horizontalmente
        ) {
            Text(text = "Botón 2")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMainMenu() {
    MainMenu()
}

