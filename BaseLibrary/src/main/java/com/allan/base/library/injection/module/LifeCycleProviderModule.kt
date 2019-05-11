package com.allan.base.library.injection.module

import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Module
import dagger.Provides

@Module
class LifeCycleProviderModule(private val lifeCycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providersLifeCycleProvider(): LifecycleProvider<*> {
        return lifeCycleProvider
    }
}