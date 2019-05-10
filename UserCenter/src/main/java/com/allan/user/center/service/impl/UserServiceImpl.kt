package com.allan.user.center.service.impl

import com.allan.base.library.data.protocol.BaseResp
import com.allan.base.library.rx.BaseExeception
import com.allan.user.center.data.repository.UserRepository
import com.allan.user.center.service.UserService
import io.reactivex.Observable
import io.reactivex.functions.Function


class UserServiceImpl : UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        val repository = UserRepository()

        return repository.register(mobile, pwd, verifyCode).flatMap(
            object : Function<BaseResp<String>, Observable<Boolean>> {
                override fun apply(t: BaseResp<String>): Observable<Boolean> {
                    if (t.status != 0) {
                        return Observable.error(BaseExeception(t.status, t.message))
                    }

                    return Observable.just(true)
                }
            }
        )
    }
}