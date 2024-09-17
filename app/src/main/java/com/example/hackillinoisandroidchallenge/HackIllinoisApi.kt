package com.example.hackillinoisandroidchallenge

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface HackIllinoisApi {
    @GET("/event/")
    fun getEvents(@Header("Authorization") authHeader: String): Call<EventResponse>
}