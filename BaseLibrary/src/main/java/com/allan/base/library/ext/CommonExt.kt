package com.allan.base.library.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.allan.base.library.data.protocol.BaseResp
import com.allan.base.library.rx.BaseFunc
import com.allan.base.library.rx.BaseFuncBoolean
import com.allan.base.library.rx.BaseObserver
import com.kotlin.base.utils.GlideUtils
import com.kotlin.base.widgets.DefaultTextWatcher
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

fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}


fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}

