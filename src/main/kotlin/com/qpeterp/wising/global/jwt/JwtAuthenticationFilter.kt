package com.qpeterp.wising.global.jwt

import com.qpeterp.wising.global.TokenExtractor
import com.qpeterp.wising.infra.token.JwtClient
import com.qpeterp.wising.infra.token.JwtPayloadKey
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtUtils: JwtClient,
    private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = TokenExtractor.extract(request)
        if (token != null) {
            jwtUtils.parseToken(token)
            setAuthentication(token)
        }
        
        doFilter(request, response, filterChain)
    }
    
    private fun setAuthentication(token: String) {
        val email = jwtUtils.payload(JwtPayloadKey.EMAIL, token)
        val details = userDetailsService.loadUserByUsername(email)
        SecurityContextHolder.getContext().authentication =
            UsernamePasswordAuthenticationToken(details, null, details.authorities)
    }
}