package com.alexparpas.sample.process.troublemakers.stateful

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.ActivityTroublemakerStatefulInstancesBinding
import javax.inject.Inject

class TroublemakerStatefulActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTroublemakerStatefulInstancesBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: TroublemakerStatefulViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityTroublemakerStatefulInstancesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}