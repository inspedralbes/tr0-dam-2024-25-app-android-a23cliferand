package com.example.tr0_dam_2024_25_app_android_a23cliferand.data

import androidx.activity.result.launch
import androidx.lifecycle.get
import androidx.lifecycle.viewModelScope
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


fun Fetch() {
    @Serializable
    data class MyDataClass(val message: String)

    val client = com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient(CIO)

    viewModelScope.launch {
        try {
            val response: HttpResponse = client.get("http://localhost:3000/get")
            val myData = Json.decodeFromString<MyDataClass>(response.bodyAsText())
            // Use myData.message
        } catch (e: Exception) {
            // Handle exceptions
        }
    }
}