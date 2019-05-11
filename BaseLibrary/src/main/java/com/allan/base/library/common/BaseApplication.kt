package com.allan.base.library.common

import android.app.Application
import com.allan.base.library.injection.component.AppComponent
import com.allan.base.library.injection.component.DaggerAppComponent
import com.allan.base.library.injection.module.AppModule


class BaseApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}