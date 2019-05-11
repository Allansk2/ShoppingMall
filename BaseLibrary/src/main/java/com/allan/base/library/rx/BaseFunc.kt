package com.allan.base.library.rx

import com.allan.base.library.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function


class BaseFunc<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        if (t.status != 0) {
            return Observable.error(BaseExeception(t.status, t.message))
        }

        return Observable.just(t.data)
    }
}