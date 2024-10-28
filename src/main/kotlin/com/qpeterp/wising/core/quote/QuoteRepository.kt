package com.qpeterp.wising.core.quote

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository: JpaRepository<QuoteEntity, Int> {
//    @Query(value = "SELECT * FROM QuoteEntity order by RAND() limit 1", nativeQuery = true)
    @Query("SELECT * FROM tbl_quote q order by RAND() LIMIT :limit", nativeQuery = true)
    fun findAllRandom(limit: Int): MutableList<QuoteEntity>
}