package com.alexparpas.sample.process.troublemakers.singleton

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.alexparpas.sample.process.R
import javax.inject.Singleton

@Singleton
object LoginManager {
    lateinit var app: Application
    private const val PREF_IS_LOGGED_IN = "PREF_IS_LOGGED_IN"

    fun init(app: Application) {
        this.app = app
    }

    var isLoggedIn: Boolean
        get() = getSharedPreferences().getBoolean(PREF_IS_LOGGED_IN, false)
        set(value) = getSharedPreferences().edit().putBoolean(PREF_IS_LOGGED_IN, value).apply()

    fun login(callback: () -> Unit) {
        isLoggedIn = true
        //Other operations

        callback.invoke()

    }

    fun logout(callback: () -> Unit) {
        isLoggedIn = false
        //Other operations

        callback.invoke()
    }

    private fun getSharedPreferences(): SharedPreferences =
        app.getSharedPreferences(app.resources.getString(R.string.app_name), Context.MODE_PRIVATE)
}