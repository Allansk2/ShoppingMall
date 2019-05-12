package com.allan.goodscenter.injection.component

import com.allan.base.library.injection.PerComponentScope
import com.allan.base.library.injection.component.ActivityComponent
import com.allan.goodscenter.injection.module.CategoryModule
import com.allan.goodscenter.ui.fragment.CategoryFragment
import dagger.Component

@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = [CategoryModule::class])
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}
