package com.allan.goodscenter.presenter

import com.allan.base.library.ext.execute
import com.allan.base.library.presenter.BasePresenter
import com.allan.base.library.rx.BaseObserver
import com.allan.goodscenter.data.protocol.Category
import com.allan.goodscenter.presenter.view.CategoryView
import com.allan.goodscenter.service.CategoryService
import javax.inject.Inject

class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {
    @Inject
    lateinit var categoryService: CategoryService

    fun getCategory(parentId: Int) {
        if (!checkNetwork()) {
            return
        }
        mView.showLoading()
        categoryService.getCategory(parentId).execute(object : BaseObserver<MutableList<Category>?>(mView) {
            override fun onNext(t: MutableList<Category>?) {
                mView.onGetCategoryResult(t)
            }
        }, lifecycleProvider)

    }

}
