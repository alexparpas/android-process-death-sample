package com.alexparpas.sample.process.examples.basic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.ActivityBasicExampleBinding
import javax.inject.Inject

class BasicExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicExampleBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: BasicExampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityBasicExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}