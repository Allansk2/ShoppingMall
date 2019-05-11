package com.allan.base.library.presenter

import com.allan.base.library.presenter.view.BaseView
import com.trello.rxlifecycle3.LifecycleProvider
import javax.inject.Inject


open class BasePresenter<V : BaseView> {
    lateinit var mView: V

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>
}