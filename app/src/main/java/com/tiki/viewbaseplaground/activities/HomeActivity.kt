package com.tiki.viewbaseplaground.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.tiki.viewbaseplaground.databinding.LayoutHomeScreenBinding
import com.tiki.viewbaseplaground.extensions.tag
import com.tiki.viewbaseplaground.practice.gesture.ViewPager2GestureTestActivity
import com.tiki.viewbaseplaground.practice.gesture.dispatch_events.view.DispatchEventActivity

class HomeActivity: BaseActivity() {
    private lateinit var binding: LayoutHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            val intent = Intent(this, DispatchEventActivity::class.java)
            startActivity(intent)
        }
    }
}