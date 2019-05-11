package com.allan.base.library.ui.activity

import android.os.Bundle
import com.allan.base.library.common.BaseApplication
import com.allan.base.library.injection.component.ActivityComponent
import com.allan.base.library.injection.component.DaggerActivityComponent
import com.allan.base.library.injection.module.ActivityModule
import com.allan.base.library.injection.module.LifeCycleProviderModule
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.presenter.view.BaseView
import com.allan.base.library.widget.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject


open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    private lateinit var mProgressLoading: ProgressLoading

    override fun showLoading() {
        mProgressLoading.showLoading()
    }

    override fun hideLoading() {
        mProgressLoading.dismiss()
    }

    override fun onError(text: String) {
        toast(text)
    }

    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mProgressLoading = ProgressLoading.create(this)

        initActivityInjection()
        initInjection()
    }

    abstract fun initInjection()

    lateinit var activityComponent: ActivityComponent

    private fun initActivityInjection() {
        activityComponent =
            DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }
}