package com.tiki.viewbaseplaground.activities

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.tiki.viewbaseplaground.databinding.LayoutBaseActivityBinding
import com.tiki.viewbaseplaground.extensions.toPx
import com.tiki.viewbaseplaground.view.TouchPointView

open class BaseActivity: AppCompatActivity() {

    private lateinit var binding : LayoutBaseActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutBaseActivityBinding.inflate(layoutInflater)
    }

    override fun setContentView(view: View?) {
        binding.root.addView(view)
        super.setContentView(binding.root.rootView)
    }
}