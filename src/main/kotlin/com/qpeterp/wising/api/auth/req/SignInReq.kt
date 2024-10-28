package com.qpeterp.wising.api.auth.req

import com.qpeterp.wising.api.auth.pattern.AuthPattern
import jakarta.validation.constraints.Pattern

data class SignInReq(
    @field:Pattern(regexp = AuthPattern.USERNAME_PATTERN, message = "invalid 'username'")
    val username: String,

    @field:Pattern(regexp = AuthPattern.PASSWORD_PATTERN, message = "invalid 'password'")
    val password: String
)