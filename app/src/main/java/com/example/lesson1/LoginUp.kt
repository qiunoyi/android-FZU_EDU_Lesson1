package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson1.databinding.ActivityLoginUpBinding
import com.example.lesson1.databinding.ActivityMainBinding

class LoginUp : AppCompatActivity() {
    private lateinit var binding: ActivityLoginUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
        binding = ActivityLoginUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //隐藏标题栏
        supportActionBar?.hide()
    }
}