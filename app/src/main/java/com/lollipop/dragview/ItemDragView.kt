package com.lollipop.dragview

import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.lollipop.kotlinnotes.LOG_TAG
import com.lollipop.kotlinnotes.databinding.ItemDragViewBinding
import java.util.*

/**
 * @Author: lollipop
 * @Time:2020/9/29
 * @Document:
 */
class ItemDragView(context: Context?) : LinearLayout(context) {

    private var layout: ItemDragViewBinding =
        ItemDragViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {

        val random = Random()
        layout.tv.setBackgroundColor((0xff000000 or random.nextInt(0x00ffffff).toLong()).toInt())
    }

    fun setTag(viewTag: String) {
        apply {
            tag = viewTag
            setOnLongClickListener {
                val item = ClipData.Item(tag as? CharSequence)
                val clipData = ClipData(
                    tag as? CharSequence,
                    arrayOf(""),
                    item
                )
                val dragShadowBuilder = DragShadowBuilder(it)

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    startDragAndDrop(clipData, dragShadowBuilder, it, 0)
                } else {
                    startDrag(clipData, dragShadowBuilder, it, 0)
                }
            }
            setOnDragListener { view, event ->
                run {
                    when (event.action) {
                        DragEvent.ACTION_DRAG_STARTED -> {
//                            Log.d(LOG_TAG, "${view.tag} start")
                        }
                        DragEvent.ACTION_DRAG_LOCATION -> {
//                        Log.d(LOG_TAG, "${view.tag} location")

                        }
                        DragEvent.ACTION_DRAG_ENTERED -> {
                            Log.d(LOG_TAG, "${view.tag} entered")

                        }
                        DragEvent.ACTION_DRAG_EXITED -> {
                            Log.d(LOG_TAG, "${view.tag} exited")

                        }
                        DragEvent.ACTION_DRAG_ENDED -> {
//                            Log.d(LOG_TAG, "${view.tag} end")
                        }
                        DragEvent.ACTION_DROP -> {
                            Log.d(LOG_TAG, "${view.tag} drop")
                        }
                    }
                    true
                }
            }
        }
        layout.tv.text = tag.toString()
    }
}