package com.allan.goodscenter.data.protocol


data class GetGoodsListByKeywordReq(
        val keyword: String,
        val pageNo: Int
)
