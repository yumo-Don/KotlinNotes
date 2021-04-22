package com.lollipop.dragview

import android.util.Log
import android.view.View
import androidx.customview.widget.ViewDragHelper
import com.lollipop.kotlinnotes.LOG_TAG

/**
 * @Author: lollipop
 * @Time:2020/10/10
 * @Document:
 */
class LollipopDragHelperCallback : ViewDragHelper.Callback() {
    override fun tryCaptureView(child: View, pointerId: Int): Boolean {
        Log.d(LOG_TAG,"tryCaptureView")
        return true
    }

    override fun onViewDragStateChanged(state: Int) {
        Log.d(LOG_TAG,"onViewDragStateChanged")
        super.onViewDragStateChanged(state)
    }

    override fun onViewPositionChanged(changedView: View, left: Int, top: Int, dx: Int, dy: Int) {
        Log.d(LOG_TAG,"onViewPositionChanged")
        super.onViewPositionChanged(changedView, left, top, dx, dy)
    }

    override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
        Log.d(LOG_TAG,"onViewReleased")

        super.onViewReleased(releasedChild, xvel, yvel)
    }

    override fun onViewCaptured(capturedChild: View, activePointerId: Int) {
        Log.d(LOG_TAG,"onViewCaptured")
        super.onViewCaptured(capturedChild, activePointerId)
    }

    override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
        Log.d(LOG_TAG,"clampViewPositionHorizontal")
        return left
    }

    override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
        Log.d(LOG_TAG,"clampViewPositionVertical")
        return top
    }
}