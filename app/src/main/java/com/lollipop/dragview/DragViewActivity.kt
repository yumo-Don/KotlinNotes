package com.lollipop.dragview

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.TextView
import androidx.customview.widget.ViewDragHelper
import androidx.drawerlayout.widget.DrawerLayout
import com.lollipop.kotlinnotes.LOG_TAG
import com.lollipop.kotlinnotes.R
import com.lollipop.kotlinnotes.databinding.ActivityDragViewBinding

class DragViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityDragViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDragViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addChildView()
    }

    private fun addChildView() {
        for (i in 0..10) {
            binding.dragGroup.addView(ItemDragView(this).apply { setTag(i.toString()) })
        }

        "".let { true }

        "".apply {  }
    }

    fun test(){
        TextView(this).apply {
            textSize = 14f
        }

        try {
            TextView(this).also {
                try {
                    it.textSize = 14f
                } catch (e: Exception) {
                }
            }
        } catch (e: Exception) {
        }

        var string:String? = null

        string?.let {
             it.length
             it.substring(0)
        }

        with(string){
            this?.length
            this?.get(0)
        }

        if (string!=null){
            string.length
        }

        kotlin.run { this }

        run {

        }
    }

}

