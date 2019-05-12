package com.allan.goodscenter.presenter.view

import com.allan.base.library.presenter.view.BaseView
import com.allan.goodscenter.data.protocol.Category


interface CategoryView : BaseView {

    fun onGetCategoryResult(result: MutableList<Category>?)
}
