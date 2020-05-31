package com.alexparpas.sample.process.examples.navigation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.FragmentNavigationExample1Binding
import com.alexparpas.sample.process.utils.viewBinding

class NavigationExampleFragment1 internal constructor() : Fragment() {

    private var binding: FragmentNavigationExample1Binding by viewBinding(FragmentNavigationExample1Binding::bind)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        FragmentNavigationExample1Binding.inflate(inflater)
            .also { binding = it }
            .root

    companion object {
        fun newInstance() = NavigationExampleFragment1()
    }
}
