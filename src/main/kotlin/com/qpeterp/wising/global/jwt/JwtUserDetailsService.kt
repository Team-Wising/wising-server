package com.qpeterp.wising.global.jwt

import com.qpeterp.wising.core.user.UserRepository
import com.qpeterp.wising.core.user.getByEmail
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsService(
    private val userRepository: UserRepository,
) : UserDetailsService {
    override fun loadUserByUsername(username: String) =
        JwtUserDetails(userRepository.getByEmail(username))
}