package com.qpeterp.wising.core.quote

import com.qpeterp.wising.core.user.UserEntity
import jakarta.persistence.*

@Entity(name = "tbl_quote")
class QuoteEntity(
    id: Int = 0,
    content: String,
    author: UserEntity
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = id
        private set

    @Column(nullable = false)
    var content = content
        private set
    
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    var author = author
        private set
}