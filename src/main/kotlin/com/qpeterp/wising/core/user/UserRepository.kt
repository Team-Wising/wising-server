package com.qpeterp.wising.core.user

import com.qpeterp.wising.global.exception.CustomException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): List<UserEntity>
    fun existsByEmail(email: String): Boolean
}

fun UserRepository.getByEmail(email: String): UserEntity =
    findByEmail(email).firstOrNull() ?: throw CustomException(HttpStatus.NOT_FOUND, "User not found")