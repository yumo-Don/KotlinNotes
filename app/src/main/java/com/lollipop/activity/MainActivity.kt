package com.lollipop.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewStub
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lollipop.dragview.DragViewActivity
import com.lollipop.jetpack.lifecycle.LollipopObserver
import com.lollipop.jetpack.viewmodle.TestViewModel
import com.lollipop.kotlinnotes.*
import com.lollipop.kotlinnotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityMainBinding
     var  a: ((Int, Int) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        viewBinding.tvJump.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        val b = { _: Int, _: Int ->Unit}

        b(1,2)



        a?.let { it(1,2) }

    }

}


