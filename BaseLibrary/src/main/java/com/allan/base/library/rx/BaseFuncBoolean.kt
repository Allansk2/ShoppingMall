package com.allan.base.library.rx

import com.allan.base.library.common.ResultCode
import com.allan.base.library.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function;


class BaseFuncBoolean<T> : Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS) {
            return Observable.error(BaseExeception(t.status, t.message))
        }

        return Observable.just(true)
    }
}