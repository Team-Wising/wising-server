package com.qpeterp.wising.global.exception

import com.qpeterp.wising.global.ErrorRes
import mu.KLogger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.resource.NoResourceFoundException

@RestControllerAdvice
class CustomExceptionHandler(
    private val logger: KLogger
) {

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(exception: CustomException): ResponseEntity<ErrorRes> {
        logger.error("CustomExceptionHandler.CustomException", exception)
        val body = ErrorRes.of(exception.status)
        return ResponseEntity.status(exception.status).body(body)
    }

    @ExceptionHandler(NoResourceFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoResourceFound(exception: NoResourceFoundException): ErrorRes {
        logger.error("CustomExceptionHandler.NoResourceFoundException", exception)
        return ErrorRes.of(HttpStatus.NOT_FOUND)
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    fun handleHttpRequestMethodNotSupported(exception: HttpRequestMethodNotSupportedException): ErrorRes {
        logger.error("CustomExceptionHandler.HttpRequestMethodNotSupportedException", exception)
        return ErrorRes.of(HttpStatus.METHOD_NOT_ALLOWED)
    }
    
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValid(exception: MethodArgumentNotValidException): ErrorRes {
        logger.error("CustomExceptionHandler.MethodArgumentNotValidException", exception)
        return ErrorRes.of(HttpStatus.BAD_REQUEST)
    }
    
    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception, webRequest: WebRequest): ErrorRes {
        logger.error("CustomExceptionHandler.Exception - $exception")
        return ErrorRes.of(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}