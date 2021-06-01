package com.example.infosungai.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.infosungai.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_komunitas.view.*

class RecyclerAdapter(private val userEmailArray: ArrayList<String>,
                      private val userCommentArray: ArrayList<String>,
                      private val userImageArray: ArrayList<String>)
    : RecyclerView.Adapter<RecyclerAdapter.PostHolder>() {

    class PostHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun getItemCount(): Int {
        return userEmailArray.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_komunitas,parent,false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.itemView.tv_Comment.text = userCommentArray.get(position)
        holder.itemView.tv_Pengirim.text = userEmailArray.get(position)
        Picasso.get().load(userImageArray[position]).into(holder.itemView.img_post)
    }
}