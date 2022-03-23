package com.example.lesson1

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化View Binding,注意在build.gradle里改了要syc now
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ActivityCollector.addActivity(this)
        //隐藏标题栏
        supportActionBar?.hide()
        //注册
        binding.LUText.setOnClickListener {
            val intent=Intent(this,LoginUp::class.java).apply {
                //这里可以加上传递的内容putExtra("param1","data1")
            }
            startActivity(intent)
        }
        //登录
        binding.LIButton.setOnClickListener{
            val intent=Intent(this,MainActivity2::class.java).apply {
            }
            startActivity(intent)
        }
    }
}

//管理Activity
object ActivityCollector{
    private val activities=ArrayList<Activity>()

    fun addActivity(activity:Activity){
        activities.add(activity)
    }

    fun removeActivity(activity:Activity){
        activities.remove(activity)
    }

    fun finishAll(){
        for(activity in activities){
            if(!activity.isFinishing){
                activity.finish()
            }
        }
        activities.clear()
    }
}