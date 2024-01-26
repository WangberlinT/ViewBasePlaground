package com.tiki.viewbaseplaground.examples.dispatch_events

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintLayout
import com.tiki.viewbaseplaground.extensions.tag

class LogConstraintLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val name: String
    private var intercept = false
    init {
        name = attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "name") ?: "${tag()}_${this.hashCode()}"
    }

    fun setIntercept(intercept: Boolean) {
        this.intercept = intercept
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(name, "start dispatchTouchEvent: ${ev?.getActionName()}")
        val result = super.dispatchTouchEvent(ev)
        Log.d(name, "end dispatchTouchEvent: ${ev?.getActionName()}, result: $result")
        return result
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(name, "start onInterceptTouchEvent: ${ev?.getActionName()}")
        val result = ev?.action != MotionEvent.ACTION_DOWN && intercept
        Log.d(name, "end onInterceptTouchEvent: ${ev?.getActionName()}, result: $intercept")
        return result
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(name, "start onTouchEvent: ${event?.getActionName()}")
        val result = super.onTouchEvent(event)
        Log.d(name, "end onTouchEvent: ${event?.getActionName()}, result: $result")
        return result
    }
}

fun MotionEvent.getActionName() = when (this.action) {
    MotionEvent.ACTION_DOWN -> "ACTION_DOWN"
    MotionEvent.ACTION_MOVE -> "ACTION_MOVE"
    MotionEvent.ACTION_UP -> "ACTION_UP"
    MotionEvent.ACTION_CANCEL -> "ACTION_CANCEL"
    else -> "OTHER_ACTION"
}