package com.samapps.kotlincourse.ui.fragments.main

import androidx.lifecycle.ViewModel
import com.samapps.kotlincourse.validators.EmailValidator

class MainViewModel : ViewModel() {
    private val emailValidator = EmailValidator.getDefaultValidator()

    private fun validateEmail(email: String): Boolean =
            validateOptional(email) {
                emailValidator.validate(email).let {
                    it.isValid
                }
            }

    private fun validateOptional(value: String, block: () -> Boolean) =
            block.takeIf { value.isNotEmpty() }?.invoke() ?: true
}