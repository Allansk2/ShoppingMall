package com.allan.user.center.data.protocol


data class RegisterReq(val mobile: String, val pwd: String, val verifyCode: String) {
}