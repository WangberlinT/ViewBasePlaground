package com.tiki.viewbaseplaground.examples.intercept_events

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import com.tiki.viewbaseplaground.extensions.tag
import kotlin.math.abs

class ViewPager2WrapperView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val thresholdTangent = 1f
    private lateinit var downEvent: MotionEvent

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        val event = ev ?: return super.dispatchTouchEvent(ev)
        if (event.action == MotionEvent.ACTION_DOWN) {
            Log.d(this.tag(), "ACTION_DOWN")
            downEvent = MotionEvent.obtain(event)
        }
        val deltaY = abs(event.y - downEvent.y)
        val deltaX = abs(event.x - downEvent.x)
        val deltaTangent = deltaY / deltaX
        Log.d(tag(), "deltaTangent: $deltaTangent")
        requestDisallowInterceptTouchEvent(deltaTangent < thresholdTangent)
        return super.onInterceptTouchEvent(ev)
    }
}