package com.kotlin.provider.common

import com.allan.base.library.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils

fun isLogined(): Boolean {
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}


fun afterLogin(method: () -> Unit) {
    if (isLogined()) {
        method()
    } else {
//        ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()
    }
}
