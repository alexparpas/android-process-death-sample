package com.alexparpas.sample.process.examples.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexparpas.sample.process.databinding.ActivityRecyclerViewExampleBinding

class RecyclerViewExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RecyclerViewExampleAdapter()
        initRecyclerView(adapter)

        adapter.submitList(generateItems(1000))
    }

    private fun initRecyclerView(adapter: RecyclerViewExampleAdapter) {
        val layoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = layoutManager
            addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        }
    }

    private fun generateItems(size: Int): List<String> {
        val items = mutableListOf<String>()

        repeat(size) {
            items.add(it.toString())
        }

        return items
    }
}