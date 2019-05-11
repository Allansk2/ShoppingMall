package com.allan.base.library.injection.component

import android.content.Context
import com.allan.base.library.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun context():Context
}