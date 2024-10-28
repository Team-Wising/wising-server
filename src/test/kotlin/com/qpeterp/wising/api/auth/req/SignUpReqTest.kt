package com.qpeterp.wising.api.auth.req

import com.qpeterp.wising.api.core.ValidatorHelper
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SignUpReqTest {
    private val validationHelper = ValidatorHelper(SignUpReq::class.java)

    @ParameterizedTest
    @ValueSource(
        strings = [
            "12", // 2글자
            "1234567890123456", // 16글자 
            "가나다라", // 한글
            "가나다라123", // 한글 또는 숫자
            "가나다라123ABC" // 한글 또는 숫자 또는 영문
        ]
    )
    fun `test valid nickname parameter`(element: String) {
        validationHelper.assertNoViolation("nickname", element)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1", // 1글자
            "12345678901234567", // 17글자
            "✅✅" // 한글 또는 숫자가 아닌 문자
        ]
    )
    fun `test invalid nickname parameter`(element: String) {
        validationHelper.assertHasViolation("nickname", element)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "abcd1234", // 8글자 이상
            "abcdabcd12345678", // 16글자 이하
        ]
    )
    fun `test valid username parameter`(element: String) {
        validationHelper.assertNoViolation("username", element)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "a123456", // 8글자 미만
            "a1234567890123456", // 16글자 초과
            "12345678", // 첫 글자가 영문이 아님
            "a123가나다라" // 영문 또는 숫자가 아님
        ]
    )
    fun `test invalid username parameter`(element: String) {
        validationHelper.assertHasViolation("username", element)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "abcd123@",
            "abCD123!",
            "abcdefghij1234567890abcdefghij123456789@" // 40자 이하
        ]
    )
    fun `test valid password parameter`(element: String) {
        validationHelper.assertNoViolation("password", element)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "a12@", // 8글자 미만
            "a123@!가나다", // 영문, 숫자가 아닌 문자가 포함됨
            "abcdefghij1234567890abcdefghij123456789@!" // 40자 초과
        ]
    )
    fun `test invalid password parameter`(element: String) {
        validationHelper.assertHasViolation("password", element)
    }
}