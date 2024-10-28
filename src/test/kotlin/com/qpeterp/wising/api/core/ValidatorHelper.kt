package com.qpeterp.wising.api.core

import jakarta.validation.Validation
import jakarta.validation.Validator
import org.junit.jupiter.api.Assertions.assertTrue

class ValidatorHelper<T>(
    private val `class`: Class<T>
) {
    private val validator: Validator = Validation.buildDefaultValidatorFactory().validator
    
    fun <P> assertNoViolation(parameterName: String, testcase: P) {
        val violations = validator.validateValue(`class`, parameterName, testcase)
        assertTrue(violations.isEmpty(), "$testcase testcase")
    }

    fun <P> assertHasViolation(parameterName: String, testcase: P) {
        val violations = validator.validateValue(`class`, parameterName, testcase)
        assertTrue(violations.isNotEmpty(), "$testcase testcase")
    }
}