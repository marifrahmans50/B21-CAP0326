package com.example.infosungai.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.infosungai.Repository
import com.example.infosungai.data.NewsData

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    private val repositpry = Repository()

    fun fetchUserData() : LiveData<MutableList<NewsData>> {
        val mutableData = MutableLiveData<MutableList<NewsData>>()
        repositpry.getUserData().observeForever { users ->
            mutableData.value = users
        }
        return mutableData
    }
}