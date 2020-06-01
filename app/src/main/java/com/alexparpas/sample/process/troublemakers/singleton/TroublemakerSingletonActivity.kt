package com.alexparpas.sample.process.troublemakers.singleton

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alexparpas.sample.process.App
import com.alexparpas.sample.process.databinding.ActivityTroublemakerSingletonBinding

class TroublemakerSingletonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTroublemakerSingletonBinding

    private val viewModel: TroublemakerSingletonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityTroublemakerSingletonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleActions()

        observeViewModel()
    }

    private fun handleActions() {
        binding.loginButton.setOnClickListener {
            viewModel.onLoginClicked()
        }

        binding.logoutButton.setOnClickListener {
            viewModel.onLogoutClicked()
        }
    }

    private fun observeViewModel() {
        viewModel.viewState.observe(this, Observer { viewState ->
            render(viewState)
        })
    }

    private fun render(viewState: TroublemakerSingletonViewModel.ViewState) {
        binding.loginButton.isEnabled = viewState.isLoginEnabled
        binding.logoutButton.isEnabled = viewState.isLogoutEnabled
        binding.loginStatusTextView.text = getString(viewState.loginStatus)
    }
}
