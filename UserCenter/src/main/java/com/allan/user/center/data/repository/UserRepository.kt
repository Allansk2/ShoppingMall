package com.allan.user.center.data.repository

import com.allan.base.library.data.net.RetrofitFactory
import com.allan.base.library.data.protocol.BaseResp
import com.allan.user.center.data.api.UserApi
import com.allan.user.center.data.protocol.RegisterReq
import io.reactivex.Observable


class UserRepository {
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile, pwd, verifyCode))
    }
}