package com.tiki.viewbaseplaground.practice.gesture

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiki.viewbaseplaground.R
import com.tiki.viewbaseplaground.activities.BaseActivity
import com.tiki.viewbaseplaground.databinding.ActivityViewPager2GestureTestBinding

class ViewPager2GestureTestActivity : BaseActivity() {

    private lateinit var binding: ActivityViewPager2GestureTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPager2GestureTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contentAdapter = ContentAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ViewPager2GestureTestActivity)
            adapter = contentAdapter
        }
        contentAdapter.submitList(
            (1..10).map { ItemUi(it, listOf(R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground)) }
        )
    }

}