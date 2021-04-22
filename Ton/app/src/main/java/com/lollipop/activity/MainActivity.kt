package com.lollipop.activity

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.MotionEvent
import android.view.ViewPropertyAnimator
import android.view.ViewStub
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lollipop.customView.ProgressView
import com.lollipop.dragview.DragViewActivity
import com.lollipop.jetpack.lifecycle.LollipopObserver
import com.lollipop.jetpack.viewmodle.TestViewModel
import com.lollipop.kotlinnotes.*
import com.lollipop.kotlinnotes.databinding.ActivityMainBinding

 fun  AppCompatActivity.jumpIntent(cls:Class<out AppCompatActivity>){
    val intent = Intent(this, cls)
    startActivity(intent)
}

class MainActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityMainBinding
    var a: ((Int, Int) -> Unit)? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        debug()

        viewBinding.progressBar.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val duration = ObjectAnimator.ofInt(v, "progress", 100).setDuration(5000)
                    duration.start()
                    true
                }
                else -> {
                    v as ProgressView
                    true
                }

            }
        }

    }

    fun debug(){
        viewBinding.tvDebug.setOnClickListener {
            jumpIntent(FragmentTestActivity::class.java)
        }
    }

    /**
     * 子线程如果使用了looper，应该如何退出looper，需手动调用looper.quit()
     *
     * 主线程 默认looper不可以退出，只会挂起
     */
    private fun testThreadLooperQuit() {
        var handler: Handler? = null
        var looper: Looper? = null
        val thread = Thread {
            Looper.prepare()
            looper = Looper.myLooper()
            handler = @SuppressLint("HandlerLeak")
            object : Handler() {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    println(msg.what)
                }
            }
            Looper.loop()
        }

        thread.start()

        for (i in 1..5) {
            handler?.sendEmptyMessage(i)
            Thread.sleep(1000)
        }

        Thread.sleep(1000)

        var count = 0

        while (true) {
            println("${thread.state}- count={$count} ")
            if (thread.state == Thread.State.TERMINATED) {
                break
            }
            Thread.sleep(1000)
            count++

            if (count == 10) {
                //子线程的looper 一定要主动quit，不然就会导致子线程死循环，一直不会销毁
                looper?.quit()
                println("looper quit ")
            }
        }
    }

}


