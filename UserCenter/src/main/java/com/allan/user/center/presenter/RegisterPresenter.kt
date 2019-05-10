package com.allan.user.presenter

import com.allan.base.library.ext.execute
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.rx.BaseObserver
import com.allan.user.center.service.impl.UserServiceImpl
import com.allan.user.center.view.RegisterView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile: String, verifyCode: String, pwd: String) {
        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd).execute(object : BaseObserver<Boolean>() {
            override fun onNext(t: Boolean) {
                mView.onRegisterResult(t)
            }
        })


    }

    fun login(mobile: String, pwd: String) {
        val userService = UserServiceImpl()
        userService.register(mobile, "", pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : BaseObserver<Boolean>() {
                override fun onNext(t: Boolean) {

                }
            })
    }
}