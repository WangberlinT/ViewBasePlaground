package com.tiki.viewbaseplaground.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tiki.viewbaseplaground.databinding.LayoutExampleItemBinding

class ExampleAdapter(
    private val onClick: (Example) -> Unit
) : ListAdapter<Example, ExampleAdapter.ViewHolder>(DiffUtil) {

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<Example>() {
            override fun areItemsTheSame(oldItem: Example, newItem: Example): Boolean {
                return oldItem.destination == newItem.destination
            }

            override fun areContentsTheSame(oldItem: Example, newItem: Example): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(val binding: LayoutExampleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Example) {
            binding.title.text = item.title
            binding.root.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutExampleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}