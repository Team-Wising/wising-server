package com.qpeterp.wising.global.exception

import org.springframework.http.HttpStatus

class CustomException(
    val status: HttpStatus,
    override val message: String
) : RuntimeException()
