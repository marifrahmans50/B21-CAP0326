package com.example.infosungai.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.infosungai.R
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val namanews1 = findViewById<TextView>(R.id.tv_news_name)
        val deskripsinews1 = findViewById<TextView>(R.id.tv_news_description)

        val namanews2 = intent.extras?.getString("name")
        val deskripsinews2 = intent.extras?.getString("description")

        Glide.with(this).load(intent.getStringExtra("imageUrl")).into(img_news)

        namanews1.text = namanews2.toString()
        deskripsinews1.text = deskripsinews2.toString()
    }
}