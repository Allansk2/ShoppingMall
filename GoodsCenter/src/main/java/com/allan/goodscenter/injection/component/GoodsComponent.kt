package com.allan.goodscenter.injection.component

import com.allan.base.library.injection.PerComponentScope
import com.allan.base.library.injection.component.ActivityComponent
import com.allan.goodscenter.injection.module.GoodsModule
import com.allan.goodscenter.ui.activity.GoodsActivity
import dagger.Component


@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = [GoodsModule::class])
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
//    fun inject(fragment: GoodsDetailTabOneFragment)
}
