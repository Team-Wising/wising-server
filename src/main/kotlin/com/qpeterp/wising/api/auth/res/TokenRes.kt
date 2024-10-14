package com.qpeterp.wising.api.auth.res

data class TokenRes(
    val accessToken: String,
    val refreshToken: String
)