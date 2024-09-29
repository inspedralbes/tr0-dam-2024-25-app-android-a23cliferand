package com.example.tr0_dam_2024_25_app_android_a23cliferand

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
class TheGames : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val image = findViewById<ImageView>(R.id.image)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questions)
    }
}