package com.example.infosungai.fragment.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.infosungai.*
import com.example.infosungai.adapter.NewsAdapter
import com.example.infosungai.ui.news.NewsActivity
import com.example.infosungai.ui.news.NewsViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: NewsAdapter
    private val viewModel by lazy { ViewModelProviders.of(this).get(NewsViewModel::class.java)}

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        /*homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })

         */

        view.btn_community.setOnClickListener{
            startActivity(Intent(context,CommunityActivity::class.java))
        }
        view.btn_location.setOnClickListener{
            startActivity(Intent(context, MapsActivity::class.java))
        }
        view.tv_news.setOnClickListener{
            startActivity(Intent(context, NewsActivity::class.java))
        }

        return view

    }
    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        rv_home.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = NewsAdapter(NewsData)
        }
    }
    fun observeData(){
        //Adding Shimmer
        //shimmer_view_container.startShimmer()
        viewModel.fetchUserData().observe(activity, Observer {
            //shimmer_view_container.stopShimmer()
            //shimmer_view_container.visibility = View.GONE
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

     */
}