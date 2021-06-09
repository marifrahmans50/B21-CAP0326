package com.example.infosungai.ui.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infosungai.PostActivity
import com.example.infosungai.R
import com.example.infosungai.adapter.RecyclerAdapter
import com.example.infosungai.databinding.ActivityCommunityBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class CommunityActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var binding: ActivityCommunityBinding

    var userEmailFromFB: ArrayList<String> = ArrayList()
    var userCommentFromFB: ArrayList<String> = ArrayList()
    var userImageFromFB: ArrayList<String> = ArrayList()

    var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = resources.getString(R.string.community)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val btnPost: FloatingActionButton = findViewById(R.id.btn_post)
        btnPost.setOnClickListener(this)

        getDataFromFirestore()

        binding.rvPost.layoutManager = LinearLayoutManager(this)
        binding.rvPost.setHasFixedSize(true)
        adapter = RecyclerAdapter(userEmailFromFB,userCommentFromFB,userImageFromFB)
        binding.rvPost.adapter = adapter

        //val layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = layoutManager

        //adapter = RecyclerAdapter(userEmailFromFB,userCommentFromFB,userImageFromFB)
        //recyclerView.adapter = adapter
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_post -> {
                val moveIntent = Intent(this@CommunityActivity, PostActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    fun getDataFromFirestore(){
        db.collection("Posts").orderBy("date",
            Query.Direction.DESCENDING).addSnapshotListener { snapshot, exception ->
            if (exception != null){
                Toast.makeText(this,exception.localizedMessage, Toast.LENGTH_SHORT).show()
            } else {
                if(snapshot != null){
                    if (!snapshot.isEmpty){

                        userImageFromFB.clear()
                        userCommentFromFB.clear()
                        userEmailFromFB.clear()

                        val documents = snapshot.documents
                        for (document in documents){
                            val comment = document.get("comment") as String
                            val useremail = document.get("userEmail") as String
                            val downloadUrl = document.get("downloadUrl") as String
                            val timestamp = document.get("date") as Timestamp
                            val date = timestamp.toDate()

                            userEmailFromFB.add(useremail)
                            userCommentFromFB.add(comment)
                            userImageFromFB.add(downloadUrl)



                            adapter!!.notifyDataSetChanged()
                        }
                    }
                }
            }
        }
    }

}