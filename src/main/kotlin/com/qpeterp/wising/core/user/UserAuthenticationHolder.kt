package com.qpeterp.wising.core.user

import com.qpeterp.wising.global.exception.CustomException
import com.qpeterp.wising.global.jwt.JwtUserDetails
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserAuthenticationHolder {
    fun current(): UserEntity {
        return (SecurityContextHolder.getContext().authentication.principal as? JwtUserDetails)?.user
            ?: throw CustomException(HttpStatus.NOT_FOUND, "Not found user")
    }
}