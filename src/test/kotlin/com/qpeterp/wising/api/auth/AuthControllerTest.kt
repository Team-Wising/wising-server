package com.qpeterp.wising.api.auth

import com.qpeterp.wising.TestDBConfiguration
import com.qpeterp.wising.api.auth.req.SignInReq
import com.qpeterp.wising.api.auth.req.SignUpReq
import com.qpeterp.wising.common.toJson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.test.Test

@TestDBConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AuthControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    private val nickname = "testNickname"
    private val username = "testUsername"
    private val password = "test123@!"

    private val signUpReq = SignUpReq(
        nickname = nickname,
        username = username,
        password = password,
    )

    private val signInReq = SignInReq(
        username = username,
        password = password,
    )

    // Sign up
    @Test
    fun `test sign up success`() {
        mockMvc.perform(
            post("/auth/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signUpReq.toJson())
        ).andExpect(status().isOk)
            .andDo(print())
    }

    @Test
    fun `test sign up failure due to invalid password format`() {
        mockMvc.perform(
            post("/auth/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signUpReq.copy(password = "123").toJson())
        ).andExpect(status().isBadRequest)
            .andDo(print())
    }

    @Test
    fun `test sign up failure due to duplicate user`() {
        mockMvc.perform(
            post("/auth/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signUpReq.toJson())
        ).andExpect(status().isOk)
            .andDo(print())
        
        mockMvc.perform(
            post("/auth/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signUpReq.toJson())
        )
            .andExpect(status().isUnauthorized)
            .andDo(print())
    }

    // Sign in
    @Test
    fun `test sign in`() {
        `test sign up success`()

        mockMvc.perform(
            post("/auth/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signInReq.toJson())
        ).andExpect(status().isOk)
    }
}