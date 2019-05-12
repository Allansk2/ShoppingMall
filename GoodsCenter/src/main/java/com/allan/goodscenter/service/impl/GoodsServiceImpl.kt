package com.allan.goodscenter.service.impl

import com.allan.base.library.ext.convert
import com.allan.goodscenter.data.protocol.Goods
import com.allan.goodscenter.data.protocol.getGoodFromDatabase
import com.allan.goodscenter.data.repository.GoodsRepository
import com.allan.goodscenter.service.GoodsService
import io.reactivex.Observable
import javax.inject.Inject


class GoodsServiceImpl @Inject constructor() : GoodsService {

    @Inject
    lateinit var repository: GoodsRepository


    override fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?> {
        return Observable.just(getGoodFromDatabase(categoryId))
//        return repository.getGoodsList(categoryId, pageNo).convert()
    }

    override fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsListByKeyword(keyword, pageNo).convert()
    }

    override fun getGoodsDetail(goodsId: Int): Observable<Goods> {
        return repository.getGoodsDetail(goodsId).convert()
    }
}
