package com.allan.user.center.service.impl

import com.allan.base.library.ext.convertBoolean
import com.allan.user.center.data.repository.UserRepository
import com.allan.user.center.service.UserService
import io.reactivex.Observable
import javax.inject.Inject


class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {

//        return Observable.just(true)

        return repository.register(mobile, pwd, verifyCode).convertBoolean()
    }
}