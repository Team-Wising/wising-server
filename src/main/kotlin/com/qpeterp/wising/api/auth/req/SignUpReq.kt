package com.qpeterp.wising.api.auth.req

import jakarta.validation.constraints.Email

data class SignUpReq(
    @Email
    val email: String,
    val password: String
)