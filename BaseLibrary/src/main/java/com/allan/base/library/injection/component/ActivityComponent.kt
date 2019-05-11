package com.allan.base.library.injection.component

import android.app.Activity
import com.allan.base.library.injection.ActivityScope
import com.allan.base.library.injection.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): Activity
}