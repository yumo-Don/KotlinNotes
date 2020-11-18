package com.lollipop.dragview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.customview.widget.ViewDragHelper

/**
 * @Author: lollipop
 * @Time:2020/10/10
 * @Document:
 */
open class LollipopDragGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val viewDragHelper: ViewDragHelper =
        ViewDragHelper.create(this, LollipopDragHelperCallback())

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return viewDragHelper.shouldInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        viewDragHelper.processTouchEvent(event)
        return true
    }

    override fun computeScroll() {
        if (viewDragHelper.continueSettling(true))
            invalidate()
    }

}