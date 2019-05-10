package com.allan.base.library.ui.activity

import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.presenter.view.BaseView
import javax.inject.Inject


open class BaseMvpActivity <T: BasePresenter<*>> : BaseActivity(), BaseView {

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    @Inject
    lateinit var mPresenter: T
}