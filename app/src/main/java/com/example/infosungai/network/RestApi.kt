package com.example.myapplication

import com.example.infosungai.data.ClassifierData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {

    @Headers("Content-Type: application/json")
    @POST("img")
    fun addUser(@Body userData: ClassifierData): Call<ClassifierData>
}