package com.allan.user.center.ui.activity

import android.os.Bundle
import android.view.View
import com.allan.base.library.ext.onClick
import com.allan.base.library.ui.activity.BaseMvpActivity
import com.allan.user.center.R
import com.allan.user.center.injection.component.DaggerUserComponent
import com.allan.user.center.injection.module.UserModule
import com.allan.user.center.view.RegisterView
import com.allan.user.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast


class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        mRegisterBtn.setOnClickListener {
//            mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
//        }

//        mRegisterBtn.onClick(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
//
//            }
//        })

        mRegisterBtn.onClick {
            mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
        }

        mGetVerifyCodeBtn.setOnClickListener {
        }
    }

    override fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this

    }

}