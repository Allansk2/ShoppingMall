package com.allan.user.center.data.api

import com.allan.base.library.data.protocol.BaseResp
import com.allan.user.center.data.protocol.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

    @POST("userCenter/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>

    @POST("userCenter/forgetPwd")
    fun forgetPwd(@Body req: ForgetPwdReq): Observable<BaseResp<String>>

    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq): Observable<BaseResp<String>>
}