package com.example.tr0_dam_2024_25_app_android_a23cliferand.data

import com.google.gson.annotations.SerializedName

data class JsonData(@SerializedName("status") var status:String, @SerializedName("message") var images: List<String>)