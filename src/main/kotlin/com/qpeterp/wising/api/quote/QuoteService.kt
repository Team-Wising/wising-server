package com.qpeterp.wising.api.quote

import com.qpeterp.wising.api.quote.res.QuoteRes
import com.qpeterp.wising.core.quote.QuoteRepository
import org.springframework.stereotype.Service

@Service
class QuoteService(
    private val quoteRepository: QuoteRepository,
) {
    fun getAll(): List<QuoteRes> {
        return quoteRepository.findAll()
            .map(QuoteRes::of)
    }
    
    fun getToday(limit: Int): List<QuoteRes> {
        return quoteRepository.findAllRandom(limit = limit)
            .map(QuoteRes::of)
    }
}