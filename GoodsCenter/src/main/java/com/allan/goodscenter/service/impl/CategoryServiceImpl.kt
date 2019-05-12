package com.allan.goodscenter.service.impl

import com.allan.base.library.ext.convert
import com.allan.goodscenter.data.protocol.Category
import com.allan.goodscenter.data.protocol.getCategoryFromDatabase
import com.allan.goodscenter.data.repository.CategoryRepository
import com.allan.goodscenter.service.CategoryService
import io.reactivex.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CategoryServiceImpl @Inject constructor() : CategoryService {
    @Inject
    lateinit var repository: CategoryRepository

    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return Observable.just(getCategoryFromDatabase(parentId))

//        return repository.getCategory(parentId).convert()
    }


}
