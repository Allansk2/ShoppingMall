package com.allan.shopping.mall.ui.activity

import android.os.Bundle
import com.allan.base.library.ext.onClick
import com.allan.base.library.ui.activity.BaseActivity
import com.allan.shopping.mall.R
import kotlinx.android.synthetic.main.activity_setting.*
import org.jetbrains.anko.toast

class SettingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        mUserProtocolTv.onClick {
            toast("用户协议")
        }
        mFeedBackTv.onClick {
            toast("反馈意见")
        }
        mAboutTv.onClick {
            toast("关于")
        }

        mLogoutBtn.onClick {

            finish()
        }
    }
}
