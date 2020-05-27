package com.alexparpas.sample.process.examples.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexparpas.sample.process.databinding.ItemRvExampleBinding
import java.util.concurrent.Executors

class RecyclerViewExampleAdapter : ListAdapter<String, RecyclerViewExampleAdapter.SingleAdapterViewHolder>(
    AsyncDifferConfig.Builder(diffCallback).setBackgroundThreadExecutor(Executors.newSingleThreadExecutor()).build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleAdapterViewHolder = SingleAdapterViewHolder.create(parent)

    override fun onBindViewHolder(holder: SingleAdapterViewHolder, position: Int) {
        (holder as? SingleAdapterViewHolder)?.bind(getItem(position))
    }

    class SingleAdapterViewHolder(private val binding: ItemRvExampleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.itemTextView.text = data
        }

        companion object {
            fun create(parent: ViewGroup) = SingleAdapterViewHolder(ItemRvExampleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}