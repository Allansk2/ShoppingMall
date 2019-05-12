package com.allan.shopping.mall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allan.base.library.ext.loadUrl
import com.allan.base.library.ext.onClick
import com.allan.base.library.ui.fragment.BaseFragment
import com.allan.shopping.mall.R
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.common.ProviderConstant
import kotlinx.android.synthetic.main.fragment_me.*

class MeFragment : BaseFragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        mUserIconIv.onClick(this)
        mUserNameTv.onClick(this)

        mWaitPayOrderTv.onClick(this)
        mWaitConfirmOrderTv.onClick(this)
        mCompleteOrderTv.onClick(this)
        mAllOrderTv.onClick(this)
        mAddressTv.onClick(this)
        mShareTv.onClick(this)
        mSettingTv.onClick(this)


    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    private fun loadData() {
//        if (isLogined()) {
        val isLogined = false
        if (isLogined) {
            val userIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if (userIcon.isNotEmpty()) {
                mUserIconIv.loadUrl(userIcon)
            }
            mUserNameTv.text = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        } else {
            mUserIconIv.setImageResource(R.drawable.icon_default_user)
            mUserNameTv.text = getString(R.string.un_login_text)
        }

    }

    override fun onClick(view: View) {
        when (view.id) {
//            R.id.mUserIconIv, R.id.mUserNameTv -> {
//                afterLogin {
//                    startActivity<UserInfoActivity>()
//                }
//            }
//
//            R.id.mWaitPayOrderTv -> {
//                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_PAY)
//            }
//            R.id.mWaitConfirmOrderTv -> {
//                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_CONFIRM)
//            }
//            R.id.mCompleteOrderTv -> {
//                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_COMPLETED)
//            }
//            R.id.mAllOrderTv -> {
//                afterLogin {
//                    startActivity<OrderActivity>()
//                }
//            }
//
//            R.id.mAddressTv -> {
//                afterLogin {
//                    startActivity<ShipAddressActivity>()
//                }
//            }
//            R.id.mShareTv -> {
//                toast(R.string.coming_soon_tip)
//            }
//            R.id.mSettingTv -> {
//                startActivity<SettingActivity>()
//            }
        }
    }

}
