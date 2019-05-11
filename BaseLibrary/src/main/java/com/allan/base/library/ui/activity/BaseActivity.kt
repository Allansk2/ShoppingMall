package com.allan.base.library.ui.activity

import android.os.Bundle
import com.allan.base.library.common.AppManager
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity


open class BaseActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        AppManager.instance.finishActivity(this)
    }
}