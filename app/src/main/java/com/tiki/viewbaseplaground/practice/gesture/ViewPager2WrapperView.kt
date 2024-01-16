package com.tiki.viewbaseplaground.practice.gesture

import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import com.tiki.viewbaseplaground.extensions.tag
import com.tiki.viewbaseplaground.extensions.toPx
import kotlin.math.abs

class ViewPager2WrapperView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val thresholdTangent = 1f
    lateinit var downEvent: MotionEvent

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val event = ev ?: return super.dispatchTouchEvent(ev)
        val result = super.dispatchTouchEvent(ev)
        if (event.action == MotionEvent.ACTION_DOWN) {
            Log.d(this.tag(), "ACTION_DOWN")
            downEvent = MotionEvent.obtain(event)
        }
        val deltaY = abs(event.y - downEvent.y)
        val deltaX = abs(event.x - downEvent.x)
        val deltaTangent = deltaY / deltaX
        Log.d(tag(), "deltaTangent: $deltaTangent")
        requestDisallowInterceptTouchEvent(deltaTangent < thresholdTangent)
        return result
    }
}