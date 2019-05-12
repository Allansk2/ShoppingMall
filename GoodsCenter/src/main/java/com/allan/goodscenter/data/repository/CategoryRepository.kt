package com.allan.goodscenter.data.repository

import com.allan.base.library.data.net.RetrofitFactory
import com.allan.base.library.data.protocol.BaseResp
import com.allan.goodscenter.data.api.CategoryApi
import com.allan.goodscenter.data.protocol.Category
import com.allan.goodscenter.data.protocol.GetCategoryReq
import io.reactivex.Observable
import javax.inject.Inject


class CategoryRepository @Inject constructor() {
    fun getCategory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java).getCategory(GetCategoryReq(parentId))
    }

}
