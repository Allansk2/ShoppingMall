package com.allan.goodscenter.data.api

import com.allan.base.library.data.protocol.BaseResp
import com.allan.goodscenter.data.protocol.Category
import com.allan.goodscenter.data.protocol.GetCategoryReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface CategoryApi {

    @POST("category/getCategory")
    fun getCategory(@Body req: GetCategoryReq): Observable<BaseResp<MutableList<Category>?>>
}
