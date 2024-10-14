package com.qpeterp.wising.api.auth.req

data class SignInReq(
    val email: String,
    val password: String
)