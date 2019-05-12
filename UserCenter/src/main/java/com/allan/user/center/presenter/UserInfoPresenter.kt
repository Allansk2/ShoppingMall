package com.allan.user.presenter

import com.allan.base.library.presenter.BasePresenter
import com.allan.user.center.service.UserService
import com.allan.user.center.view.UserInfoView
import javax.inject.Inject


class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, verifyCode: String, pwd: String) {

    }
}