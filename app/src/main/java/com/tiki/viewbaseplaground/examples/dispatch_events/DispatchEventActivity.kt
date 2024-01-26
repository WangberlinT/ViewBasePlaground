package com.tiki.viewbaseplaground.examples.dispatch_events

import android.os.Bundle
import com.tiki.viewbaseplaground.home.BaseActivity
import com.tiki.viewbaseplaground.databinding.LayoutLogMotionEventBinding

class DispatchEventActivity : BaseActivity() {

    private var _binding: LayoutLogMotionEventBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = LayoutLogMotionEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewGroupIntercept.setOnCheckedChangeListener {
            _, isChecked -> binding.ViewGroupB.setIntercept(isChecked)
        }
        binding.viewGroupConsume.setOnCheckedChangeListener {
            _, isChecked -> binding.ViewGroupB.isClickable = isChecked
        }

        binding.viewCConsume.setOnCheckedChangeListener {
            _, isChecked -> binding.viewC.isClickable = isChecked
        }
        binding.viewCDisallow.setOnCheckedChangeListener {
            _, isChecked -> binding.viewC.setDisallowIntercept(isChecked)
        }
        binding.viewDConsume.setOnCheckedChangeListener {
            _, isChecked -> binding.viewD.isClickable = isChecked
        }
        binding.viewDDisallow.setOnCheckedChangeListener {
            _, isChecked -> binding.viewD.setDisallowIntercept(isChecked)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}