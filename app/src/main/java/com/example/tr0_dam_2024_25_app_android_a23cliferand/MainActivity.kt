package com.example.tr0_dam_2024_25_app_android_a23cliferand

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        button1.setOnClickListener {
            try {
                val intent = Intent(this, TheGames::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error launching TheGames activity", Toast.LENGTH_SHORT).show()
            }
        }

        button2.setOnClickListener {
            finishAffinity()
        }

    }


    fun fetchJsonArray(urlString: String): ArrayList<String>? {
        val resultArray = ArrayList<String>()

        try {
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val response = inputStream.bufferedReader().use { it.readText() }

                val jsonArray = JSONArray(response)

                for (i in 0 until jsonArray.length()) {
                    val item = jsonArray.getString(i)
                    resultArray.add(item)
                }
            }

            connection.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return resultArray
    }
}
