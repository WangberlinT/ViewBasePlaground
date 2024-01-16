package com.tiki.viewbaseplaground.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import com.tiki.viewbaseplaground.extensions.tag
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.tiki.viewbaseplaground.extensions.toPx

class TouchPointView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {
    init {
        setBackgroundColor(Color.TRANSPARENT)
    }

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.RED
        style = Paint.Style.FILL
    }

    private var showTouchPoint: Boolean = false
    private var radius: Float = 20.toPx().toFloat()
    private var point: PointF = PointF(0f, 0f)

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val result = super.dispatchTouchEvent(ev)
        val event = ev ?: return result
        when (event.action) {
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_MOVE -> {
                point = PointF(event.x, event.y)
                showTouchPoint = true
            }
            else -> {
                showTouchPoint = false
            }
        }
        invalidate()
        return result
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return true
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        if (!showTouchPoint) return
        canvas.drawCircle(point.x, point.y, radius, paint)
    }
}