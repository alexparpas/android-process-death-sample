package com.alexparpas.sample.process.examples.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecyclerViewExampleViewModel : ViewModel() {
    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    private val currentViewState get() = requireNotNull(viewState.value)

    init {
        _viewState.value = ViewState()
        _viewState.value = currentViewState.copy(items = generateItems(1000))
    }

    private fun generateItems(size: Int): List<String> {
        val items = mutableListOf<String>()

        repeat(size) {
            items.add(it.toString())
        }

        return items
    }

    data class ViewState(
        val items: List<String> = listOf()
    )
}