package com.example.myapplication

import com.example.infosungai.data.ClassifierData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun addUser(userData: ClassifierData, onResult: (ClassifierData?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<ClassifierData> {
                override fun onFailure(call: Call<ClassifierData>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<ClassifierData>, response: Response<ClassifierData>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}