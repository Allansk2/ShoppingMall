package com.allan.base.library.ext

import android.view.View
import com.allan.base.library.data.protocol.BaseResp
import com.allan.base.library.rx.BaseFunc
import com.allan.base.library.rx.BaseFuncBoolean
import com.allan.base.library.rx.BaseObserver
import com.trello.rxlifecycle3.LifecycleProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.execute(observer: BaseObserver<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribeOn(Schedulers.io())
        .subscribe(observer)
}


fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}


fun View.onClick(listener: View.OnClickListener): View {
    setOnClickListener(listener)
    return this
}

fun View.onClick(method: () -> Unit): View {
    setOnClickListener { method() }
    return this
}

