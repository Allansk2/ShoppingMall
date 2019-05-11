package com.allan.user.presenter

import com.allan.base.library.ext.execute
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.rx.BaseObserver
import com.allan.user.center.data.protocol.UserInfo
import com.allan.user.center.service.UserService
import com.allan.user.center.view.LoginView
import javax.inject.Inject


class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var userService: UserService

    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetwork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd, pushId).execute(object : BaseObserver<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                mView.onLoginResult(t)
                mView.hideLoading()
            }
        }, lifecycleProvider)
    }

}