package com.alexparpas.sample.process.examples.recycler

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.ActivityRecyclerViewExampleBinding
import javax.inject.Inject

class RecyclerViewExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewExampleBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: RecyclerViewExampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RecyclerViewExampleAdapter()
        initRecyclerView(adapter)

        adapter.submitList(generateItems(1000))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //Save recycler view state
        val rvState = binding.recyclerView.layoutManager?.onSaveInstanceState()
        outState.putParcelable(ARG_RV_STATE, rvState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val rvState = savedInstanceState.getParcelable<Parcelable>(ARG_RV_STATE)
        rvState?.let { binding.recyclerView.layoutManager?.onRestoreInstanceState(it) }
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

    companion object {
        const val ARG_RV_STATE = "ARG_RV_STATE"
    }
}