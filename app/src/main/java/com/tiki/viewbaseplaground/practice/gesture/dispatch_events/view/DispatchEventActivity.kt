package com.tiki.viewbaseplaground.practice.gesture.dispatch_events.view

import android.os.Bundle
import com.tiki.viewbaseplaground.activities.BaseActivity
import com.tiki.viewbaseplaground.databinding.LayoutLogMotionEventBinding

class DispatchEventActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LayoutLogMotionEventBinding.inflate(layoutInflater).root)
    }
}