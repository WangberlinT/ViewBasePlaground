package com.tiki.viewbaseplaground.practice.gesture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tiki.viewbaseplaground.databinding.LayoutItemBinding


class ContentAdapter : ListAdapter<ItemUi, ContentAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<ItemUi>() {
        override fun areItemsTheSame(oldItem: ItemUi, newItem: ItemUi): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemUi, newItem: ItemUi): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemUi) {
            binding.gallery.adapter = GalleryAdapter().apply {
                submitList(item.imageResIds)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutItemBinding.inflate(
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