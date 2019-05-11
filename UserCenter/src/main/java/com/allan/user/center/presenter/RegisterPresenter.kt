package com.allan.user.presenter

import android.util.Log
import com.allan.base.library.ext.execute
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.rx.BaseObserver
import com.allan.user.center.service.UserService
import com.allan.user.center.service.impl.UserServiceImpl
import com.allan.user.center.view.RegisterView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, verifyCode: String, pwd: String) {
        if (!checkNetwork()) {
            return
        }
        mView.showLoading()
        userService.register(mobile, verifyCode, pwd).execute(object : BaseObserver<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t) {
                    mView.onRegisterResult("注册成功")
                    mView.hideLoading()
                }
            }
        }, lifecycleProvider)
    }


    fun login(mobile: String, pwd: String) {
        val userService = UserServiceImpl()
        userService.register(mobile, "", pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : BaseObserver<Boolean>(mView) {
                override fun onNext(t: Boolean) {

                }
            })
    }
}