package com.qpeterp.wising.api.user.dto

import com.qpeterp.wising.core.user.UserEntity

data class UserRes(
    val id: Long,
    val email: String,
) {
    companion object {
        fun of(user: UserEntity) = UserRes(
            id = user.id, 
            email = user.username,
        )
    }
}