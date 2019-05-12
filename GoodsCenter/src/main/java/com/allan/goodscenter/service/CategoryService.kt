package com.allan.goodscenter.service

import com.allan.goodscenter.data.protocol.Category
import io.reactivex.Observable

interface CategoryService {
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>
}

