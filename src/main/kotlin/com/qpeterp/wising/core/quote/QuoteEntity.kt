package com.qpeterp.wising.core.quote

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "tbl_quote")
class QuoteEntity(
    id: Int = 0,
    content: String,
    author: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        private set
    
    var content = content
        private set
    
    var author = author
        private set
}