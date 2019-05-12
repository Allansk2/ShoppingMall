package com.allan.base.library.ui.fragment

import android.os.Bundle
import com.allan.base.library.common.BaseApplication
import com.allan.base.library.injection.component.ActivityComponent
import com.allan.base.library.injection.component.DaggerActivityComponent
import com.allan.base.library.injection.module.ActivityModule
import com.allan.base.library.injection.module.LifeCycleProviderModule
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject


open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError(text: String) {
        toast(text)
    }

    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()
        initInjection()
    }

    abstract fun initInjection()

    lateinit var activityComponent: ActivityComponent

    private fun initActivityInjection() {
        activityComponent =
            DaggerActivityComponent.builder().appComponent((activity?.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(requireActivity()))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }
}