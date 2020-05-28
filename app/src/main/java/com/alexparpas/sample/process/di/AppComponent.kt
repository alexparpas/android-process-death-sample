package com.alexparpas.sample.process.di

import com.alexparpas.sample.process.MainActivity
import com.alexparpas.sample.process.examples.basic.BasicExampleActivity
import com.alexparpas.sample.process.examples.navigation.NavigationExampleActivity
import com.alexparpas.sample.process.examples.recycler.RecyclerViewExampleActivity
import com.alexparpas.sample.process.troublemakers.singleton.TroublemakerSingletonActivity
import com.alexparpas.sample.process.troublemakers.stateful.TroublemakerStatefulActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(basicExampleActivity: BasicExampleActivity)
    fun inject(navigationExampleActivity: NavigationExampleActivity)
    fun inject(recyclerViewExampleActivity: RecyclerViewExampleActivity)
    fun inject(troublemakerSingletonActivity: TroublemakerSingletonActivity)
    fun inject(troublemakerStatefulActivity: TroublemakerStatefulActivity)
}