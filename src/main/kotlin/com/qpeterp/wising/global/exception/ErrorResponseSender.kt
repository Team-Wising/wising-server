package com.qpeterp.wising.global.exception

import com.qpeterp.wising.global.error.ErrorRes
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletResponse
import mu.KLogger
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class ErrorResponseSender(
    private val objectMapper: ObjectMapper,
    private val logger: KLogger
) {

    fun send(response: HttpServletResponse, customException: CustomException) =
        send(response, customException.status, customException.message)

    fun send(response: HttpServletResponse, status: HttpStatus, message: String? = null) {
        response.apply {
            this.status = status.value()
            contentType = MediaType.APPLICATION_JSON_VALUE
            characterEncoding = "UTF-8"
        }
        try {
            response.writer.write(
                objectMapper.writeValueAsString(
                    ErrorRes(
                        status = status.value(),
                        message = message ?: status.reasonPhrase
                    )
                )
            )
        } catch (e: IOException) {
            logger.error("ErrorResponseSender.send", e)
        }
    }
}