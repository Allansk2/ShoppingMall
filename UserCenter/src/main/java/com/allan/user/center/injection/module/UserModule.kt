package com.allan.user.center.injection.module

import com.allan.user.center.service.UserService
import com.allan.user.center.service.impl.UserServiceImpl

class UserModule {

    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }
}
