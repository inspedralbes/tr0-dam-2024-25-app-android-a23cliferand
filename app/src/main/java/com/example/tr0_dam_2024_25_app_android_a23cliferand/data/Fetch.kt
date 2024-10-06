package com.example.tr0_dam_2024_25_app_android_a23cliferand.data

import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL


import kotlinx.serialization.Serializable



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

@Serializable
data class PreguntesResponse(
    val preguntes: List<Pregunta>
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

fun main() {
    val url = "http://192.168.1.137:3000/getQuestionsAndroid"
    val preguntes = getJson(url)
    println(preguntes)
}