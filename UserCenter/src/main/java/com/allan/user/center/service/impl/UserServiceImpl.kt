package com.allan.user.center.service.impl

import com.allan.base.library.data.protocol.BaseResp
import com.allan.base.library.rx.BaseExeception
import com.allan.user.center.data.repository.UserRepository
import com.allan.user.center.service.UserService
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject


class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {

        return Observable.just(true)

//        return repository.register(mobile, pwd, verifyCode).flatMap(
//            object : Function<BaseResp<String>, Observable<Boolean>> {
//                override fun apply(t: BaseResp<String>): Observable<Boolean> {
//                    if (t.status != 0) {
//                        return Observable.error(BaseExeception(t.status, t.message))
//                    }
//
//                    return Observable.just(true)
//                }
//            }
//        )
    }
}