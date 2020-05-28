package com.alexparpas.sample.process.troublemakers.singleton

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.ActivityTroublemakerSingletonBinding
import javax.inject.Inject

class TroublemakerSingletonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTroublemakerSingletonBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: TroublemakerSingletonViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityTroublemakerSingletonBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}