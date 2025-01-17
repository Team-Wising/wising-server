package com.qpeterp.wising.global.jwt

import com.qpeterp.wising.global.exception.CustomException
import com.qpeterp.wising.global.exception.ErrorResponseSender
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtExceptionFilter(
    private val sender: ErrorResponseSender
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (exception: CustomException) {
            sender.send(response, exception)
        } catch (exception: Exception) {
            sender.send(response, status = HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}