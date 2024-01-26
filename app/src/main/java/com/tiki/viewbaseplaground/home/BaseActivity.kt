package com.tiki.viewbaseplaground.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tiki.viewbaseplaground.databinding.LayoutBaseActivityBinding

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