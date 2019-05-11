package com.allan.user.center.injection.component

import com.allan.base.library.injection.PerComponentScope
import com.allan.base.library.injection.component.ActivityComponent
import com.allan.user.center.injection.module.UserModule
import com.allan.user.center.ui.activity.ForgetPwdActivity
import com.allan.user.center.ui.activity.LoginActivity
import com.allan.user.center.ui.activity.RegisterActivity
import com.allan.user.center.ui.activity.ResetPwdActivity
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [UserModule::class])
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
}