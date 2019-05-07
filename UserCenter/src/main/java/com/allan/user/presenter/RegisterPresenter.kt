package com.allan.user.presenter

import com.allan.base.library.presenter.BasePresenter
import com.allan.user.view.RegisterView


class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile: String, verifyCode: String) {
        mView.onRegisterResult(true)
    }
}