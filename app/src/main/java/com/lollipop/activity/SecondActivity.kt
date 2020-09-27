package com.lollipop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lollipop.jetpack.lifecycle.LollipopObserver
import com.lollipop.kotlinnotes.R

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        addObserver()

    }

    override fun onResume() {
        super.onResume()
    }

    private fun addObserver() {
        lifecycle.addObserver(LollipopObserver())
    }
}