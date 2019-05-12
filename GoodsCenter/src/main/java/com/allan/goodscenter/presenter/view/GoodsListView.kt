package com.allan.goodscenter.presenter.view

import com.allan.base.library.presenter.view.BaseView
import com.allan.goodscenter.data.protocol.Goods

interface GoodsListView : BaseView {

    fun onGetGoodsListResult(result: MutableList<Goods>?)
}
