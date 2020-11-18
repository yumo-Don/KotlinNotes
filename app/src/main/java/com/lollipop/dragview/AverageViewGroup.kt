package com.lollipop.dragview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.customview.widget.ViewDragHelper
import com.lollipop.kotlinnotes.R
import java.util.*

/**
 * @Author: lollipop
 * @Time:2020/9/29
 * @Document:
 */
class AverageViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val viewDragHelper: ViewDragHelper =
        ViewDragHelper.create(this, LollipopDragHelperCallback())

    //屏幕宽度
    private var screenWidthPx = 0

    //子view水平间距
    private var horizontalSpace = 0

    //子view垂直间距
    private var verticalSpace = 0

    //一行子view的个数
    private var numColumns = 0

    //所有子view的集合
    private val mAllViews: MutableList<MutableList<View>> = ArrayList()

    //每行子view的最大高度的集合
    private val mLineHeight: MutableList<Int> = ArrayList()

    init {
        if (attrs != null) {
            val array = context.obtainStyledAttributes(attrs, R.styleable.AverageViewGroup)
            numColumns = array.getInt(R.styleable.AverageViewGroup_numColumns, 2)
            horizontalSpace = array.getDimensionPixelSize(
                R.styleable.AverageViewGroup_horizontalSpace,
                20
            )
            verticalSpace = array.getDimensionPixelSize(
                R.styleable.AverageViewGroup_verticalSpace,
                20
            )
            array.recycle()
        }
        val metrics: DisplayMetrics = context.resources.displayMetrics
        screenWidthPx = metrics.widthPixels
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams? {
        return MarginLayoutParams(p)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams? {
        return MarginLayoutParams(context, attrs)
    }

    override fun generateDefaultLayoutParams(): LayoutParams? {
        return MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val sizeWidth = MeasureSpec.getSize(widthMeasureSpec)
        val sizeHeight = MeasureSpec.getSize(heightMeasureSpec)
        val modeWidth = MeasureSpec.getMode(widthMeasureSpec)
        val modeHeight = MeasureSpec.getMode(heightMeasureSpec)
        val paddingRight = paddingRight
        val paddingLeft = paddingLeft
        val measureWidthSize: Int =
            (sizeWidth - paddingLeft - paddingRight - (numColumns - 1) * horizontalSpace) / numColumns
        var width = 0
        var height = 0
        var lineWidth = 0
        var lineHeight = 0
        val cCount = childCount
        for (i in 0 until cCount) {
            val child = getChildAt(i)
            if (child.visibility == GONE) {
                continue
            }
            val childWidthMeasureSpec =
                MeasureSpec.makeMeasureSpec(measureWidthSize, MeasureSpec.EXACTLY)
            child.measure(childWidthMeasureSpec, heightMeasureSpec)
            val lp = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth + lp.leftMargin + lp.rightMargin
            val childHeight = child.measuredHeight + lp.topMargin + lp.bottomMargin
            if (lineWidth + childWidth > sizeWidth - paddingLeft - paddingRight) {
                width = lineWidth.coerceAtLeast(childWidth)
                lineWidth = childWidth
                lineHeight = childHeight
                height += lineHeight + verticalSpace
            } else {
                lineWidth += if (lineWidth == 0) {
                    childWidth
                } else {
                    childWidth + horizontalSpace
                }
                lineHeight = lineHeight.coerceAtLeast(childHeight)
                if (height == 0) {
                    height = lineHeight
                }
                if (width == 0) {
                    width = lineWidth
                }
            }
        }
        height += paddingBottom
        setMeasuredDimension(
            if (modeWidth == MeasureSpec.EXACTLY) sizeWidth else width,
            if (modeHeight == MeasureSpec.EXACTLY) sizeHeight else height
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        mAllViews.clear()
        mLineHeight.clear()
        val width = width
        var lineWidth = 0
        var lineHeight = 0
        var lineViews: MutableList<View> = ArrayList()
        val cCount = childCount
        for (i in 0 until cCount) {
            val child = getChildAt(i)
            val lp = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight
            val childRequireWidth = childWidth + lp.leftMargin + lp.rightMargin
            if (childRequireWidth + lineWidth > width) {
                mLineHeight.add(lineHeight)
                mAllViews.add(lineViews)
                lineWidth = 0
                lineHeight = 0
                lineViews = ArrayList()
            }
            lineWidth += if (lineWidth == 0) {
                childRequireWidth
            } else {
                childRequireWidth + horizontalSpace
            }
            lineHeight = lineHeight.coerceAtLeast(childHeight + lp.topMargin + lp.bottomMargin)
            lineViews.add(child)
        }
        mLineHeight.add(lineHeight)
        mAllViews.add(lineViews)
        var left = 0
        var top = 0
        val lineNums: Int = mAllViews.size
        for (i in 0 until lineNums) {
            lineViews = mAllViews[i]
            lineHeight = mLineHeight[i]
            for (j in lineViews.indices) {
                val child = lineViews[j]
                if (child.visibility == GONE) {
                    continue
                }
                val lp = child.layoutParams as MarginLayoutParams
                val lc: Int = left + lp.leftMargin + paddingLeft + j * horizontalSpace
                val tc: Int = top + lp.topMargin + i * verticalSpace
                val rc = lc + child.measuredWidth
                val bc = tc + child.measuredHeight
                child.layout(lc, tc, rc, bc)
                left += child.measuredWidth + lp.rightMargin + lp.leftMargin
            }
            left = 0
            top += lineHeight
        }
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