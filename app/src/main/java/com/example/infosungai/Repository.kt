package com.example.infosungai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.infosungai.data.NewsData
import com.google.firebase.firestore.FirebaseFirestore

class Repository {

    fun getUserData() : LiveData<MutableList<NewsData>> {
        val mutableData = MutableLiveData<MutableList<NewsData>>()
        val listData = mutableListOf<NewsData>()
        val db = FirebaseFirestore.getInstance()
        FirebaseFirestore.getInstance().collection("news").get().addOnSuccessListener { result ->
            for (document in result){
                var imageUrl    = document.getString("imageUrl")
                var name        = document.getString("name")
                var description = document.getString("description")

                val user = NewsData(imageUrl!!, name!!, description!!)
                listData.add(user)
            }
            mutableData.value = listData
        }
        return mutableData
    }
}