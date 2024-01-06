package com.tiki.viewbaseplaground.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.tiki.viewbaseplaground.databinding.LayoutHomeScreenBinding
import com.tiki.viewbaseplaground.extensions.tag

class HomeActivity: BaseActivity() {
    private lateinit var binding: LayoutHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            Log.d(tag(), "bottom on clicked")
        }
    }
}