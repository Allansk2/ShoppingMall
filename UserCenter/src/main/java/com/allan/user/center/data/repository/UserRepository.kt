package com.allan.user.center.data.repository

import com.allan.base.library.data.net.RetrofitFactory
import com.allan.base.library.data.protocol.BaseResp
import com.allan.user.center.data.api.UserApi
import com.allan.user.center.data.protocol.LoginReq
import com.allan.user.center.data.protocol.RegisterReq
import com.allan.user.center.data.protocol.UserInfo
import io.reactivex.Observable
import javax.inject.Inject


class UserRepository @Inject constructor() {
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile, pwd, verifyCode))
    }

    fun login(mobile: String, pwd: String, pushId: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile, pwd, pushId))
    }
}