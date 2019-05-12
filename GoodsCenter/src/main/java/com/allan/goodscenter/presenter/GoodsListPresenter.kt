package com.allan.goodscenter.presenter

import com.allan.base.library.ext.execute
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.rx.BaseObserver
import com.allan.goodscenter.data.protocol.Goods
import com.allan.goodscenter.presenter.view.GoodsListView
import com.allan.goodscenter.service.GoodsService
import javax.inject.Inject

class GoodsListPresenter @Inject constructor() : BasePresenter<GoodsListView>() {

    @Inject
    lateinit var goodsService: GoodsService


    fun getGoodsList(categoryId: Int, pageNo: Int) {
        if (!checkNetwork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsList(categoryId, pageNo).execute(object : BaseObserver<MutableList<Goods>?>(mView) {
            override fun onNext(t: MutableList<Goods>?) {
                mView.onGetGoodsListResult(t)
            }
        }, lifecycleProvider)

    }


    fun getGoodsListByKeyword(keyword: String, pageNo: Int) {
        if (!checkNetwork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsListByKeyword(keyword, pageNo).execute(object : BaseObserver<MutableList<Goods>?>(mView) {
            override fun onNext(t: MutableList<Goods>?) {
                mView.onGetGoodsListResult(t)
            }
        }, lifecycleProvider)

    }

}
