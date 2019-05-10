package com.allan.user.center.service

import io.reactivex.Observable

interface UserService {
    fun register(mobile: String, pwd:String, verifyCode: String) : Observable<Boolean>

}