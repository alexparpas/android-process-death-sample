package com.alexparpas.sample.process.examples.navigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.ActivityNavigationBinding
import javax.inject.Inject

class NavigationExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: NavigationExampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}