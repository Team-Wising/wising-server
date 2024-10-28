package com.qpeterp.wising.global

import org.springframework.http.HttpStatus

data class ErrorRes(
    val status: Int,
    val message: String
) {
    companion object {
        fun of(status: HttpStatus) = ErrorRes(
            status = status.value(),
            message = status.reasonPhrase
        )
    }
}