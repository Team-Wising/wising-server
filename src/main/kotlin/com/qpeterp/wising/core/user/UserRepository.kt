package com.qpeterp.wising.core.user

import com.qpeterp.wising.global.exception.CustomException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Int> {
    fun findByUsername(username: String): List<UserEntity>
    fun existsByUsername(username: String): Boolean
}

fun UserRepository.getByEmail(email: String): UserEntity =
    findByUsername(email).firstOrNull() ?: throw CustomException(HttpStatus.NOT_FOUND, "User not found")