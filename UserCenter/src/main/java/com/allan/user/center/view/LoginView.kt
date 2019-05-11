package com.allan.user.center.view

import com.allan.base.library.presenter.view.BaseView
import com.allan.user.center.data.protocol.UserInfo


interface LoginView : BaseView {
    fun onLoginResult(result: UserInfo)
}