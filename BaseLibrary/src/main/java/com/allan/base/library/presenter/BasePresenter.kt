package com.allan.base.library.presenter

import com.allan.base.library.presenter.view.BaseView


open class BasePresenter<V : BaseView> {
    lateinit var mView: V
}