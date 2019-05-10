package com.allan.user.center.view

import com.allan.base.library.presenter.view.BaseView


interface RegisterView : BaseView {
    fun onRegisterResult(result: Boolean)
}