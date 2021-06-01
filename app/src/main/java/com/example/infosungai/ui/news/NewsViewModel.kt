package com.example.infosungai.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.infosungai.Repository
import com.example.infosungai.data.NewsData


class NewsViewModel : ViewModel() {


    private val repositpry = Repository()

    fun fetchUserData() : LiveData<MutableList<NewsData>> {
        val mutableData = MutableLiveData<MutableList<NewsData>>()
        repositpry.getUserData().observeForever { users ->
            mutableData.value = users
        }
        return mutableData
    }

}