package com.lollipop.dragview

import android.content.ClipData
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.lollipop.kotlinnotes.LOG_TAG
import com.lollipop.kotlinnotes.databinding.ItemDragViewBinding

/**
 * @Author: lollipop
 * @Time:2020/9/29
 * @Document:
 */
class ItemDragView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var dragListener: OnDragListener
    private var layout: ItemDragViewBinding

    init {
        dragListener = OnDragListener { view, event ->
            run {
                when (event.action) {
                    DragEvent.ACTION_DRAG_STARTED -> {
                        Log.d(LOG_TAG, "${view.id} start")
                    }
                    DragEvent.ACTION_DRAG_LOCATION -> {
                        Log.d(LOG_TAG, "${view.id} location")

                    }
                    DragEvent.ACTION_DRAG_ENTERED -> {
                        Log.d(LOG_TAG, "${view.id} entered")

                    }
                    DragEvent.ACTION_DRAG_EXITED -> {
                        Log.d(LOG_TAG, "${view.id} exited")

                    }
                    DragEvent.ACTION_DRAG_ENDED -> {
                        Log.d(LOG_TAG, "${view.id} end")
                    }
                    DragEvent.ACTION_DROP -> {
                        Log.d(LOG_TAG, "${view.id} drop")
                    }
                }
                true
            }
        }
        layout =  ItemDragViewBinding.inflate(LayoutInflater.from(context), this, true)
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
            setOnDragListener(dragListener)
        }
    }
}