package com.qpeterp.wising.api.auth

import com.qpeterp.wising.api.auth.req.SignUpReq
import com.qpeterp.wising.api.auth.req.RefreshReq
import com.qpeterp.wising.api.auth.req.SignInReq
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Auth")
@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody @Valid req: SignUpReq) =
        authService.signUp(req)

    @PostMapping("/sign-in")
    fun signIn(@RequestBody @Valid req: SignInReq) =
        authService.signIn(req)
    
    @PostMapping("/refresh")
    fun refresh(@RequestBody @Valid req: RefreshReq) =
        authService.refresh(req)
}