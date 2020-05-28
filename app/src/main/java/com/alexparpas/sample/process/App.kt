package com.alexparpas.sample.process

import android.app.Application
import com.alexparpas.sample.process.di.AppComponent
import com.alexparpas.sample.process.di.AppModule
import com.alexparpas.sample.process.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}