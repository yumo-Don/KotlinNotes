package com.lollipop.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.lollipop.kotlinnotes.R

class ProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val rectF = RectF(0f,0f,200f,200f)

    init {
        paint.color =context.resources.getColor(R.color.colorPrimary)
        paint.isAntiAlias = true
        paint.strokeWidth = 5f
        paint.textSize = 14f
        paint.style = Paint.Style.STROKE
    }

    private var progress:Int = 0
        set(value) {
            field = value
            invalidate()
        }

    public fun cancelProgress(){

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(progress.toString(),50f,50f,paint)
        canvas.drawArc(rectF,0f,progress* 3.6f,false,paint)
    }

}