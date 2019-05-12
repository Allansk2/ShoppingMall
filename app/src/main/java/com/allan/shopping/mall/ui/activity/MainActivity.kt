package com.allan.shopping.mall.ui.activity

import android.os.Bundle
import com.allan.base.library.ui.activity.BaseActivity
import com.allan.shopping.mall.R
import com.allan.shopping.mall.ui.fragment.HomeFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        val manager = supportFragmentManager.beginTransaction()
        manager.replace(R.id.mContainer, HomeFragment())
        manager.commit()
    }
}
