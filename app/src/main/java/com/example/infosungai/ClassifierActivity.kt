package com.example.infosungai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.infosungai.databinding.ActivityClassifierBinding
import com.example.infosungai.databinding.ActivityNewsBinding

class ClassifierActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassifierBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassifierBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}