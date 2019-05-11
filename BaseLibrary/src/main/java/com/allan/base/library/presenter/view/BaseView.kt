package com.allan.base.library.presenter.view


interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun onError(text: String)
}