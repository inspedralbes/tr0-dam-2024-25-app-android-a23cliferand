
package com.example.tr0_dam_2024_25_app_android_a23cliferand.data

import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getData(@Url url:String): Call<JsonData>
}