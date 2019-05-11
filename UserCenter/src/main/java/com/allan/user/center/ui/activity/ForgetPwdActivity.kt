package com.allan.user.center.ui.activity

import android.os.Bundle
import android.view.View
import com.allan.base.library.ext.enable
import com.allan.base.library.ext.onClick
import com.allan.base.library.ui.activity.BaseMvpActivity
import com.allan.user.center.R
import com.allan.user.center.data.protocol.UserInfo
import com.allan.user.center.injection.component.DaggerUserComponent
import com.allan.user.center.injection.module.UserModule
import com.allan.user.center.view.LoginView
import com.allan.user.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class ForgetPwdActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    override fun onLoginResult(result: UserInfo) {
        toast(result.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {
        mLoginBtn.onClick(this)
        mHeaderBar.getRightView().onClick(this)

        mLoginBtn.enable(mMobileEt, { isButtonEnable() })
        mLoginBtn.enable(mPwdEt, { isButtonEnable() })
    }

    override fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)

        mPresenter.mView = this
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.mRightTv -> {
                startActivity<RegisterActivity>()
            }

            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(), "")
            }
        }
    }

    private fun isButtonEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}