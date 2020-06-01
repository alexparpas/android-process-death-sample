package com.alexparpas.sample.process.troublemakers.singleton

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexparpas.sample.process.R

class TroublemakerSingletonViewModel : ViewModel() {
    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    private val currentViewState get() = requireNotNull(viewState.value)

    init {
        _viewState.value = ViewState()

        if (LoginManager.isLoggedIn) {
            onLoginSuccess()
        } else {
            onLoginFailed()
        }
    }

    fun onLoginClicked() {
        LoginManager.login {
            onLoginSuccess()
        }
    }

    fun onLogoutClicked() {
        LoginManager.logout {
            onLoginFailed()
        }
    }

    private fun onLoginSuccess() {
        _viewState.value = currentViewState.copy(
            loginStatus = R.string.logged_in_status,
            isLoginEnabled = false,
            isLogoutEnabled = true
        )
    }

    private fun onLoginFailed() {
        _viewState.value = currentViewState.copy(
            loginStatus = R.string.logged_out_status,
            isLoginEnabled = true,
            isLogoutEnabled = false
        )
    }

    data class ViewState(
        @StringRes val loginStatus: Int = R.string.empty_string,
        val isLoginEnabled: Boolean = false,
        val isLogoutEnabled: Boolean = false
    )
}