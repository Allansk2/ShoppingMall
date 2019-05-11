package com.allan.base.library.injection.module

import android.content.Context
import com.allan.base.library.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun providersContext(): Context {
        return context
    }
}