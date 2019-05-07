package com.allan.base.library.ui.activity

import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.presenter.view.BaseView


open class BaseMvpActivity <T: BasePresenter<*>> : BaseActivity(), BaseView {

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    lateinit var mPresenter: T
}