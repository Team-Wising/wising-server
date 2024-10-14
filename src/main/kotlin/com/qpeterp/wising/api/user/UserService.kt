package com.qpeterp.wising.api.user

import com.qpeterp.wising.api.user.dto.UserRes
import com.qpeterp.wising.core.user.UserAuthenticationHolder
import com.qpeterp.wising.core.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userAuthenticationHolder: UserAuthenticationHolder
) {
    fun getMe(): UserRes = UserRes.of(
        userAuthenticationHolder.current()
    )
}