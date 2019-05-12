package com.allan.goodscenter.injection.module

import com.allan.goodscenter.service.CategoryService
import com.allan.goodscenter.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

@Module
class CategoryModule {

    @Provides
    fun provideCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }

}
