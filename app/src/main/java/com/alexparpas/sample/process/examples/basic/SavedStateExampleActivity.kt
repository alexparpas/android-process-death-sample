package com.alexparpas.sample.process.examples.basic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.ActivitySavedStateExampleBinding
import javax.inject.Inject

class SavedStateExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySavedStateExampleBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SavedStateExampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivitySavedStateExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleActions()

        observeViewModel()
    }

    private fun handleActions() {
        binding.saveButton.setOnClickListener {
            viewModel.onSaveClicked(
                Form(
                    firstName = binding.firstNameEditTex.text.toString(),
                    lastName = binding.lastNameEditText.text.toString(),
                    age = binding.ageEditText.text.toString(),
                    address = binding.addressEditText.text.toString(),
                    gender = binding.genderEditText.text.toString()
                )
            )
        }
    }

    private fun observeViewModel() {
        viewModel.formLiveData.observe(this, Observer { form ->
            binding.savedTextView.text = "Saved in ViewModel $form"
        })
    }
}