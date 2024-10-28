package com.qpeterp.wising.api.quote.res

import com.qpeterp.wising.core.quote.QuoteEntity

data class QuoteRes(
    val id: Int,
    val content: String,
    val author: String
) {
    companion object {
        fun of(entity: QuoteEntity) = QuoteRes(
            id = entity.id,
            content = entity.content,
            author = entity.author
        )
    }
}