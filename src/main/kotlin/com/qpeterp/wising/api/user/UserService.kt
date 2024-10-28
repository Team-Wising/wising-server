package com.qpeterp.wising.api.user

import com.qpeterp.wising.api.user.dto.UserRes
import com.qpeterp.wising.core.user.UserAuthenticationHolder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userAuthenticationHolder: UserAuthenticationHolder
) {
    fun getMe(): UserRes = UserRes.of(
        userAuthenticationHolder.current()
    )
}