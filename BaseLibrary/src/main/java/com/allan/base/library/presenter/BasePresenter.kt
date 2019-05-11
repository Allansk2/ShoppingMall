package com.allan.base.library.presenter

import android.content.Context
import com.allan.base.library.presenter.view.BaseView
import com.kotlin.base.utils.NetWorkUtils
import com.trello.rxlifecycle3.LifecycleProvider
import javax.inject.Inject


open class BasePresenter<V : BaseView> {
    lateinit var mView: V

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetwork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}