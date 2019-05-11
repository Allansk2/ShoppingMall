package com.allan.user.center.service

import com.allan.user.center.data.protocol.UserInfo
import io.reactivex.Observable

interface UserService {
    fun register(mobile: String, pwd:String, verifyCode: String) : Observable<Boolean>

    fun login(mobile: String, pwd:String, pushId: String) : Observable<UserInfo>

}