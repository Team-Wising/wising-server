package com.qpeterp.wising.api.auth

import com.qpeterp.wising.TestDBConfiguration
import com.qpeterp.wising.api.auth.req.SignUpReq
import com.qpeterp.wising.common.toJson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import kotlin.test.Test

@TestDBConfiguration
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc
    
    @Test
    fun `test sign up success`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/auth/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    SignUpReq(
                        nickname = "testNickname",
                        username = "testUsername",
                        password = "testPassword",
                    ).toJson()
                )
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
    
    @Test
    fun `test sign up failure`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/auth/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    SignUpReq(
                        nickname = "testNickname",
                        username = "testUsername",
                        password = "testPassword",
                    ).toJson()
                )
        ).andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andDo(MockMvcResultHandlers.print())
    }
    
//    @Test
//    fun `test sign in`() {
//        `test sign up success`()
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.post("/auth/sign-in")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(
//                    SignInReq(
//                        username = "testUsername",
//                        password = "testPassword",
//                    ).toJson()
//                )
//        ).andExpect(MockMvcResultMatchers.status().isOk)
//    }
}