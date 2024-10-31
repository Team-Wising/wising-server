package com.qpeterp.wising.api.quote

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Quote")
@RestController
@RequestMapping("/quotes")
class QuoteController(
    private val quoteService: QuoteService
) {
    @GetMapping
    fun getAll() = quoteService.getAll()

    @GetMapping("/today")
    fun getTodayAll(
        @RequestParam("limit") limit: Int = 20
    ) = quoteService.getToday(limit = limit)
}