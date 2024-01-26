package com.tiki.viewbaseplaground.examples.dispatch_events

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class LogView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var disallowIntercept = false
    private val name: String
    init {
        name = attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "name") ?: this.hashCode().toString()
    }

    fun setDisallowIntercept(disallowIntercept: Boolean) {
        this.disallowIntercept = disallowIntercept
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(name, "start dispatchTouchEvent: ${ev?.getActionName()}")
        val result = super.dispatchTouchEvent(ev)
        Log.d(name, "end dispatchTouchEvent: ${ev?.getActionName()}, result: $result")
        return result
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(name, "start onTouchEvent: ${event?.getActionName()}")
        if (event?.action == MotionEvent.ACTION_DOWN) {
            parent.requestDisallowInterceptTouchEvent(disallowIntercept)
        }
        val result = super.onTouchEvent(event)
        Log.d(name, "end onTouchEvent: ${event?.getActionName()}, result: $result")
        return result
    }
}