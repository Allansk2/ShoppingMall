package com.allan.user.presenter

import com.allan.base.library.ext.execute
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.rx.BaseObserver
import com.allan.user.center.service.UserService
import com.allan.user.center.view.ResetPwdView
import javax.inject.Inject


class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {
    @Inject
    lateinit var userService: UserService

    fun resetPwd(mobile: String, pwd: String) {
        if (!checkNetwork()) {
            return
        }
        mView.showLoading()
        userService.resetPwd(mobile, pwd).execute(object : BaseObserver<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t) {
                    mView.onResetPwdResult("密码重试成功")
                    mView.hideLoading()
                }
            }
        }, lifecycleProvider)
    }
}