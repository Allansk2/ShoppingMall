package com.allan.user.center.ui.activity

import android.os.Bundle
import android.view.View
import com.allan.base.library.common.AppManager
import com.allan.base.library.ext.enable
import com.allan.base.library.ext.onClick
import com.allan.base.library.ui.activity.BaseMvpActivity
import com.allan.user.center.R
import com.allan.user.center.injection.component.DaggerUserComponent
import com.allan.user.center.injection.module.UserModule
import com.allan.user.center.view.RegisterView
import com.allan.user.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast


class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()
    }

    private fun initView() {
        mRegisterBtn.onClick(this)
        mVerifyCodeBtn.onClick(this)

        mRegisterBtn.enable(mMobileEt, {isButtonEnable()})
        mRegisterBtn.enable(mVerifyCodeEt, {isButtonEnable()})
        mRegisterBtn.enable(mPwdEt, {isButtonEnable()})
        mRegisterBtn.enable(mPwdConfirmEt, {isButtonEnable()})
    }

    override fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)

        mPresenter.mView = this
    }


    private var pressTime: Long = 0

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            pressTime = time
            toast("再按一次退出程序")
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证码成功")
            }
            R.id.mRegisterBtn -> {
                mPresenter.register(mMobileEt.text.toString(), mVerifyCodeEt.text.toString(), mPwdEt.text.toString())
            }
        }
    }

    private fun isButtonEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}