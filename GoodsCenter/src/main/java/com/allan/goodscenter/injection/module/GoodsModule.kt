package com.allan.goodscenter.injection.module

import com.allan.goodscenter.service.GoodsService
import com.allan.goodscenter.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides


@Module
class GoodsModule {

    @Provides
    fun provideGoodservice(goodsService: GoodsServiceImpl): GoodsService {
        return goodsService
    }

}
