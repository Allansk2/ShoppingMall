package com.allan.user.center.ui.activity

import android.os.Bundle
import com.allan.base.library.ui.activity.BaseMvpActivity
import com.allan.user.center.R
import com.allan.user.center.injection.component.DaggerUserComponent
import com.allan.user.center.injection.module.UserModule
import com.allan.user.center.view.RegisterView
import com.allan.user.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast


class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initInjection()

        mRegisterBtn.setOnClickListener {
            mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
        }

    }

    private fun initInjection() {
        DaggerUserComponent.builder().userModule(UserModule()).build().inject(this)
        mPresenter.mView = this

    }

}