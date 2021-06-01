package com.example.infosungai.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.infosungai.R
import com.example.infosungai.data.NewsData
import com.example.infosungai.databinding.ItemCardviewNewsBinding
import kotlinx.android.synthetic.main.item_cardview_news.view.*
import java.lang.IllegalArgumentException

class NewsAdapter(private val context: Context, private val onClickListenner : OnClickListenner) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var dataList = mutableListOf<NewsData>()

    interface OnClickListenner{
        fun onItemClick(data: NewsData)
    }

    fun setListData(data : MutableList<NewsData>){
        dataList = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_cardview_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataList.size > 0){
            return dataList.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        when (holder){

            is NewsViewHolder -> holder.bindView(dataList[position], position)

            else -> throw IllegalArgumentException("***")
        }
    }

    inner class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(user: NewsData, position: Int){

            itemView.setOnClickListener { onClickListenner.onItemClick(user) }

            Glide.with(context).load(user.imageUrl).into(itemView.newsImg)
            itemView.newsName.text       = user.name
            itemView.newsDeskripsi.text = user.description
        }
    }


}
