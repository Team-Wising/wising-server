package com.qpeterp.wising.api.auth

import com.qpeterp.wising.global.exception.CustomException
import com.qpeterp.wising.api.auth.req.RefreshReq
import com.qpeterp.wising.api.auth.req.SignInReq
import com.qpeterp.wising.api.auth.req.SignUpReq
import com.qpeterp.wising.api.auth.res.TokenRes
import com.qpeterp.wising.core.user.UserEntity
import com.qpeterp.wising.core.user.UserRepository
import com.qpeterp.wising.core.user.getByEmail
import com.qpeterp.wising.infra.token.JwtClient
import com.qpeterp.wising.infra.token.JwtPayloadKey
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


@Service
class AuthService(
    private val userRepository: UserRepository,
    private val jwtClient: JwtClient,
) {
    fun signIn(req: SignInReq): TokenRes {
        val user = userRepository.findByUsername(req.username).firstOrNull()
            ?: throw CustomException(HttpStatus.NOT_FOUND, "Not found user")
        return jwtClient.generate(user)
    }

    fun signUp(req: SignUpReq): TokenRes {
        val exists = userRepository.existsByUsername(req.username)
        if (exists) {
            throw CustomException(HttpStatus.UNAUTHORIZED, "User already exists")
        }
        
        val user = userRepository.save(
            UserEntity(
                username = req.username,
                password = req.password,
            )
        )

        return jwtClient.generate(user)
    }

    fun refresh(req: RefreshReq): TokenRes {
        val user = run {
            val email = jwtClient.payload(JwtPayloadKey.EMAIL, req.refreshToken)
            userRepository.getByEmail(email)
        }

        return jwtClient.generate(user)
    }
}