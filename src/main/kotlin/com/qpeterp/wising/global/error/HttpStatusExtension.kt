package com.qpeterp.wising.global.error

import org.springframework.http.HttpStatus

fun HttpStatus.toErrorRes() = ErrorRes(
    status = this.value(),
    message = this.reasonPhrase
)