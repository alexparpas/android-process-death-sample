package com.alexparpas.sample.process.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexparpas.sample.process.examples.basic.SavedStateExampleViewModel
import com.alexparpas.sample.process.examples.navigation.NavigationExampleViewModel
import com.alexparpas.sample.process.examples.recycler.RecyclerViewExampleViewModel
import com.alexparpas.sample.process.troublemakers.singleton.TroublemakerSingletonViewModel
import com.alexparpas.sample.process.troublemakers.stateful.TroublemakerStatefulViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SavedStateExampleViewModel::class)
    abstract fun bindSavedStateExampleViewModel(savedStateExampleViewModel: SavedStateExampleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TroublemakerStatefulViewModel::class)
    abstract fun bindTroublemakerStatefulViewModel(troublemakerStatefulViewModel: TroublemakerStatefulViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TroublemakerSingletonViewModel::class)
    abstract fun bindTroublemakerSingletonViewModel(troublemakerSingletonViewModel: TroublemakerSingletonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecyclerViewExampleViewModel::class)
    abstract fun bindRecyclerViewExampleViewModel(recyclerViewExampleViewModel: RecyclerViewExampleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NavigationExampleViewModel::class)
    abstract fun bindNavigationExampleViewModel(navigationExampleViewModel: NavigationExampleViewModel): ViewModel
}