package com.allan.base.library.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun providersActivity(): Activity {
        return activity
    }
}