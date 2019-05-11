package com.allan.user.presenter

import com.allan.base.library.ext.execute
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.rx.BaseObserver
import com.allan.user.center.service.UserService
import com.allan.user.center.view.ForgetPwdView
import javax.inject.Inject


class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {
    @Inject
    lateinit var userService: UserService

    fun forgetPwd(mobile: String, verifyCode: String) {
        if (!checkNetwork()) {
            return
        }
        mView.showLoading()
        userService.forgetPwd(mobile, verifyCode).execute(object : BaseObserver<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t) {
                    mView.onForgetPwdResult("验证成功")
                    mView.hideLoading()
                }
            }
        }, lifecycleProvider)
    }
}