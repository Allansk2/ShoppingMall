package com.allan.user.center.injection.module

import com.allan.user.center.service.UserService
import com.allan.user.center.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserModule {
    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }
}
