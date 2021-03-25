package com.samapps.kotlincourse.validators

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ValidationResponse(
    val isValid: Boolean,
    @StringRes val errorRes: Int,
    @DrawableRes val errorIconRes: Int? = null
)