package com.example.infosungai.ui.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infosungai.adapter.NewsAdapter
import com.example.infosungai.data.NewsData
import com.example.infosungai.databinding.ActivityNewsBinding
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity(), NewsAdapter.OnClickListenner {

    private lateinit var adapter: NewsAdapter
    private lateinit var binding: ActivityNewsBinding

    private val viewModel by lazy { ViewModelProviders.of(this).get(NewsViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        adapter = NewsAdapter(this, this)
        rv_news.adapter = adapter
        observeData()
    }

    fun observeData(){
        //Adding Shimmer
        viewModel.fetchUserData().observe(this, Observer {
            //shimmer_view_container.stopShimmer()
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }


    override fun onItemClick(data: NewsData) {
        //Toast.makeText(this, "$name has just clicked", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailNews::class.java)
        intent.putExtra("name", data.name)
        intent.putExtra("description", data.description)
        intent.putExtra("imageUrl", data.imageUrl)
        startActivity(intent)
    }
}
