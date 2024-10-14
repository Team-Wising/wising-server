package com.qpeterp.wising.infra.token

enum class JwtPayloadKey(
    val key: String
) {
    ID("id"),
    EMAIL("email"),
    ROLE("role");
}