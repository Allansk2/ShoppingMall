package com.allan.base.library.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allan.base.library.common.BaseApplication
import com.allan.base.library.injection.component.ActivityComponent
import com.allan.base.library.injection.component.DaggerActivityComponent
import com.allan.base.library.injection.module.ActivityModule
import com.allan.base.library.injection.module.LifeCycleProviderModule
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.presenter.view.BaseView
import com.allan.base.library.widget.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject


open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initActivityInjection()
        injectComponent()

        mLoadingDialog = ProgressLoading.create(requireContext())

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    protected abstract fun injectComponent()


    private fun initActivityInjection() {
        mActivityComponent =
            DaggerActivityComponent.builder().appComponent((activity?.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(requireActivity()))
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }


    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text: String) {
        toast(text)
    }
}