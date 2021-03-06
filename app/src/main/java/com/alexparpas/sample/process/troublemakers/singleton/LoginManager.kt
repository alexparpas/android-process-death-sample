package com.alexparpas.sample.process.troublemakers.singleton

import javax.inject.Singleton

@Singleton
object LoginManager {
    var isLoggedIn: Boolean = false
        private set

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
}