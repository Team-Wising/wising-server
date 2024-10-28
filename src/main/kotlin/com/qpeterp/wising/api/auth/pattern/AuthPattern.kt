package com.qpeterp.wising.api.auth.pattern

object AuthPattern {
    // 2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성. 한글 초성 및 모음은 허가하지 않는다.
    const val NICKNAME_PATTERN = "^(?=.*[a-zA-Z0-9가-힣])[a-zA-Z0-9가-힣]{2,16}\$"
    
    // 8자 이상 16자 이하, 영어 또는 숫자로 구성. 첫 글자는 영문자.
    const val USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9]{7,15}\$"
    
    // 8자 이상 40자 이하, 영문, 숫자, 특수문자로 구성.
    const val PASSWORD_PATTERN = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#\$%^&*])[a-zA-Z\\d!@#\$%^&*]{8,40}\$"
}