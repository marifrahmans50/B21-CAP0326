package com.example.infosungai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val namamakanan1 = findViewById<TextView>(R.id.tv_news_name)
        val deskripsi1 = findViewById<TextView>(R.id.tv_news_description)

        val namamakanan2 = intent.extras?.getString("name")
        val deskripsi2 = intent.extras?.getString("description")

        /*Glide
            .with(this)
            .load(itemphoto2)
            .centerCrop()
            .into(itemphoto1)

         */
        Glide.with(this).load(intent.getStringExtra("imageUrl")).into(img_news)

        namamakanan1.text = namamakanan2.toString()
        deskripsi1.text = deskripsi2.toString()
    }
}