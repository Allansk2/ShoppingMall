package com.allan.goodscenter.data.api

import com.allan.base.library.data.protocol.BaseResp
import com.allan.goodscenter.data.protocol.GetGoodsDetailReq
import com.allan.goodscenter.data.protocol.GetGoodsListByKeywordReq
import com.allan.goodscenter.data.protocol.GetGoodsListReq
import com.allan.goodscenter.data.protocol.Goods
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


interface GoodsApi {
    @POST("goods/getGoodsList")
    fun getGoodsList(@Body req: GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>>

    @POST("goods/getGoodsListByKeyword")
    fun getGoodsListByKeyword(@Body req: GetGoodsListByKeywordReq): Observable<BaseResp<MutableList<Goods>?>>

    @POST("goods/getGoodsDetail")
    fun getGoodsDetail(@Body req: GetGoodsDetailReq): Observable<BaseResp<Goods>>
}
