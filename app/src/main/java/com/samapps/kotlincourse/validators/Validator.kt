package com.samapps.kotlincourse.validators

interface Validator {

    fun validate(value: String?): ValidationResponse
}