package com.allan.base.library.ui.activity

import android.os.Bundle
import com.allan.base.library.common.BaseApplication
import com.allan.base.library.injection.component.ActivityComponent
import com.allan.base.library.injection.component.DaggerActivityComponent
import com.allan.base.library.injection.module.ActivityModule
import com.allan.base.library.injection.module.LifeCycleProviderModule
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.presenter.view.BaseView
import javax.inject.Inject


open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()
    }

    lateinit var activityComponent: ActivityComponent

    private fun initActivityInjection() {
        activityComponent =
            DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }
}