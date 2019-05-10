package com.allan.user.center.service.impl

import com.allan.user.center.service.UserService
import io.reactivex.Observable


class UserServiceImpl : UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)

//        val repository = UserRepository()
//
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