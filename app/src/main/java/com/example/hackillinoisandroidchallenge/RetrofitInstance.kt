package com.example.hackillinoisandroidchallenge

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://adonix.hackillinois.org/"

    val api: HackIllinoisApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HackIllinoisApi::class.java)
    }
}
