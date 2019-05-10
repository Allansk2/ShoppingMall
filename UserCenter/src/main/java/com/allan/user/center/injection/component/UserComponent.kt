package com.allan.user.center.injection.component

import com.allan.user.center.injection.module.UserModule
import com.allan.user.center.ui.activity.RegisterActivity
import dagger.Component

@Component(modules = [UserModule::class])
interface UserComponent {
    fun inject(activity: RegisterActivity)
}