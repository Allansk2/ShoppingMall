package com.allan.user.view

import com.allan.base.library.presenter.view.BaseView


interface RegisterView : BaseView {
    fun onRegisterResult(result: Boolean)
}