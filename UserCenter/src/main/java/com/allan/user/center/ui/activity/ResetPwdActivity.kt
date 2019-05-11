package com.allan.user.center.ui.activity

import android.os.Bundle
import android.view.View
import com.allan.base.library.ext.enable
import com.allan.base.library.ext.onClick
import com.allan.base.library.ui.activity.BaseMvpActivity
import com.allan.user.center.R
import com.allan.user.center.injection.component.DaggerUserComponent
import com.allan.user.center.injection.module.UserModule
import com.allan.user.center.view.ResetPwdView
import com.allan.user.presenter.ResetPwdPresenter
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.clearTop
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast


class ResetPwdActivity : BaseMvpActivity<ResetPwdPresenter>(), ResetPwdView, View.OnClickListener {

    override fun onResetPwdResult(result: String) {
        toast(result)
        startActivity(intentFor<LoginActivity>().singleTop().clearTop())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)

        initView()
    }

    private fun initView() {
        mConfirmBtn.onClick(this)

        mConfirmBtn.enable(mPwdEt, { isButtonEnable() })
        mConfirmBtn.enable(mPwdConfirmEt, { isButtonEnable() })
    }

    override fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)

        mPresenter.mView = this
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.mConfirmBtn -> {
                if (mPwdEt.text.toString() != mPwdConfirmEt.text.toString()) {
                    toast("密码不一致")
                    return
                }
                mPresenter.resetPwd(intent.getStringExtra("mobile"), mPwdEt.text.toString())
            }
        }
    }

    private fun isButtonEnable(): Boolean {
        return mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}