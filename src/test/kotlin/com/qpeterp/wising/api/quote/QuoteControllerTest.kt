package com.qpeterp.wising.api.quote

import com.qpeterp.wising.TestDBConfiguration
import com.qpeterp.wising.core.quote.QuoteRepository
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@TestDBConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class QuoteControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc
    
    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll(@Autowired quoteRepository: QuoteRepository) {
            quoteRepository.saveAll(
                listOf(
                    // TODO: Add entities
                )
            )
        }
    }
    
    @Test
    fun `test get all`() {
        mockMvc.perform(
            get("/quotes")
        ).andExpect(status().isOk)
    }
}