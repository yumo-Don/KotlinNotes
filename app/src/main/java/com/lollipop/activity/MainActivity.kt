package com.lollipop.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lollipop.Jetpack.lifecycle.LollipopObserver
import com.lollipop.Jetpack.viewmodle.TestViewModel
import com.lollipop.kotlinnotes.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model: TestViewModel by viewModels()
        model.content = "lollipop"

        val tv = findViewById<TextView>(R.id.tv)
        tv.text = model.content
        tv.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        addObserver()
    }

    private fun addObserver(){
        lifecycle.addObserver(LollipopObserver())
    }

}
