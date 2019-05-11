package com.allan.base.library.injection.component

import android.app.Activity
import android.content.Context
import com.allan.base.library.injection.ActivityScope
import com.allan.base.library.injection.module.ActivityModule
import com.allan.base.library.injection.module.LifeCycleProviderModule
import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, LifeCycleProviderModule::class])
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
    fun lifeCycleProvider(): LifecycleProvider<*>
}