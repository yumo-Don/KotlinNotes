package com.lollipop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lollipop.kotlinnotes.R
import com.lollipop.kotlinnotes.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class CoroutineActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityCoroutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.tvStart.setOnClickListener {
        }
    }

    private fun test() {
        GlobalScope.launch(Dispatchers.IO) {
            println("1".plus(Thread.currentThread().name))
            testMain()
            println("2".plus(Thread.currentThread().name))
        }

        println("3".plus(Thread.currentThread().name))
        for (i in 0..1000) {
            println("5 ---{$i}")
        }
        println("5".plus(Thread.currentThread().name))
    }

    private suspend fun testMain() {
        measureTimeMillis {  }
        withContext(Dispatchers.Main) {
            println("4".plus(Thread.currentThread().name))
        }
    }

}