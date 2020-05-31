package com.alexparpas.sample.process.examples.navigation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.FragmentNavigationExample2Binding
import com.alexparpas.sample.process.utils.viewBinding

class NavigationExampleFragment2 internal constructor() : Fragment() {

    private var binding: FragmentNavigationExample2Binding by viewBinding(FragmentNavigationExample2Binding::bind)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FragmentNavigationExample2Binding.inflate(inflater)
            .also { binding = it }
            .root

    companion object {
        fun newInstance() = NavigationExampleFragment2()
    }
}
