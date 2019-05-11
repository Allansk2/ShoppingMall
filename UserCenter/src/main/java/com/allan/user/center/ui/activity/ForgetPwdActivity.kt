package com.allan.user.center.ui.activity

import android.os.Bundle
import android.view.View
import com.allan.base.library.ext.enable
import com.allan.base.library.ext.onClick
import com.allan.base.library.ui.activity.BaseMvpActivity
import com.allan.user.center.R
import com.allan.user.center.injection.component.DaggerUserComponent
import com.allan.user.center.injection.module.UserModule
import com.allan.user.center.view.ForgetPwdView
import com.allan.user.presenter.ForgetPwdPresenter
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView, View.OnClickListener {

    override fun onForgetPwdResult(result: String) {
        toast(result)
        startActivity<ResetPwdActivity>("mobile" to mMobileEt.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)

        initView()
    }

    private fun initView() {
        mNextBtn.onClick(this)
        mVerifyCodeBtn.onClick(this)

        mNextBtn.enable(mMobileEt, { isButtonEnable() })
        mNextBtn.enable(mVerifyCodeEt, { isButtonEnable() })
    }

    override fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)

        mPresenter.mView = this
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证码成功")
            }

            R.id.mNextBtn -> {
                mPresenter.forgetPwd(mMobileEt.text.toString(), mVerifyCodeEt.text.toString())
            }
        }
    }

    private fun isButtonEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }
}