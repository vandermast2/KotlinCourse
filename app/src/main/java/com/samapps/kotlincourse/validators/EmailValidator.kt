package com.samapps.kotlincourse.validators

import android.text.TextUtils
import android.util.Patterns
import androidx.annotation.StringRes
import com.samapps.kotlincourse.R
import com.samapps.kotlincourse.extentions.EMPTY

open class EmailValidator private constructor(
        @StringRes private val invalidError: Int,
        private val additionalRegex: Regex?
) : Validator {

    companion object {

        fun builder() = Builder()

        fun getDefaultValidator() = builder().build()
    }

    override fun validate(email: String?) =
        ValidationResponse(isEmailValid(email ?: String.EMPTY), invalidError)

    private fun isEmailValid(email: String): Boolean =
        !(email.isEmpty() || TextUtils.isDigitsOnly(email))
                && email.matches(Patterns.EMAIL_ADDRESS.toRegex())
                && additionalCheck(email)

    private fun additionalCheck(email: String) = additionalRegex?.matches(email) ?: true

    class Builder {
        private var invalidError: Int = R.string.optional_info_email_invalid
        private var additionalRegex: Regex? = null
        fun build() = EmailValidator(invalidError, additionalRegex)
    }
}