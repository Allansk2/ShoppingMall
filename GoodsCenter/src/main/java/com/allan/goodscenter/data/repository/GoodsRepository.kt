package com.allan.goodscenter.data.repository

import com.allan.base.library.data.net.RetrofitFactory
import com.allan.base.library.data.protocol.BaseResp
import com.allan.goodscenter.data.api.GoodsApi
import com.allan.goodscenter.data.protocol.GetGoodsDetailReq
import com.allan.goodscenter.data.protocol.GetGoodsListByKeywordReq
import com.allan.goodscenter.data.protocol.GetGoodsListReq
import com.allan.goodscenter.data.protocol.Goods
import io.reactivex.Observable
import javax.inject.Inject

class GoodsRepository @Inject constructor() {

    fun getGoodsList(categoryId: Int, pageNo: Int): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java).getGoodsList(GetGoodsListReq(categoryId, pageNo))
    }

    fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java)
            .getGoodsListByKeyword(GetGoodsListByKeywordReq(keyword, pageNo))
    }

    fun getGoodsDetail(goodsId: Int): Observable<BaseResp<Goods>> {
        return RetrofitFactory.instance.create(GoodsApi::class.java).getGoodsDetail(GetGoodsDetailReq(goodsId))
    }
}
