package com.qpeterp.wising.api.user

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "User")
@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @GetMapping("me")
    fun getMe() = userService.getMe()
}