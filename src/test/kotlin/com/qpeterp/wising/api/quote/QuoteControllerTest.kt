package com.qpeterp.wising.api.quote

import com.qpeterp.wising.TestDBConfiguration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@TestDBConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class QuoteControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc
    
    @Test
    fun `test get all`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/quotes")
        ).andExpect(MockMvcResultMatchers.status().isOk)
    }
}