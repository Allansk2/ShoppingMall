package com.allan.user.center.service.impl

import com.allan.base.library.ext.convert
import com.allan.base.library.ext.convertBoolean
import com.allan.user.center.data.protocol.UserInfo
import com.allan.user.center.data.repository.UserRepository
import com.allan.user.center.service.UserService
import io.reactivex.Observable
import javax.inject.Inject


class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {

        return Observable.just(true)

//        return repository.register(mobile, pwd, verifyCode).convertBoolean()
    }

    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
//        return Observable.just(true)

        return repository.login(mobile, pwd, pushId).convert()

    }

    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return Observable.just(true)

//        return repository.forgetPwd(mobile, verifyCode).convertBoolean()
    }

    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)

//        return repository.resetPwd(mobile, pwd).convertBoolean()
    }
}