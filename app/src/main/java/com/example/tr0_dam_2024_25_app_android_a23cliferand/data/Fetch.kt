package com.example.tr0_dam_2024_25_app_android_a23cliferand.data

import com.example.tr0_dam_2024_25_app_android_a23cliferand.respuestasSeleccionadas
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL


import kotlinx.serialization.Serializable
import java.io.OutputStream


@Serializable
data class Resposta(
    val id: Int,
    val resposta: String,
    )

@Serializable
data class Pregunta(
    val id: String,
    val pregunta: String,
    val respostes: List<Resposta>,
    val imatge: String?,
    val text: String?
)

fun getString(urlString: String): String {
    val url = URL(urlString)
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    return try {
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            connection.inputStream.bufferedReader().use { it.readText() }
        } else {
            "Error: ${connection.responseCode}"
        }
    } finally {
        connection.disconnect()
    }
}

fun getJson(url : String): List<Pregunta> {
    val gson = Gson()
    val result = getString(url)
    val preguntesResponse = gson.fromJson(result, Array<Pregunta>::class.java).toList()
    return preguntesResponse
}

fun sendResponses(url: String): String {
    var response = ""
    CoroutineScope(Dispatchers.IO).launch {
        val urlConnection = URL(url).openConnection() as HttpURLConnection
        urlConnection.requestMethod = "PUT"
        urlConnection.doOutput = true
        urlConnection.setRequestProperty("Content-Type", "application/json")

        try {
            val outputStream: OutputStream = urlConnection.outputStream
            outputStream.write(Gson().toJson(respuestasSeleccionadas).toByteArray(Charsets.UTF_8))
            outputStream.flush()
            outputStream.close()

            if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                response = urlConnection.inputStream.bufferedReader().use { it.readText() }
            } else {
                response = "Error: ${urlConnection.responseCode}"
            }
        } finally {
            urlConnection.disconnect()
        }
    }
    return response
}

fun main() {
    val url = "http://192.168.1.134:3000/getQuestionsAndroid"
    val result = getJson(url);
    print(result)
}