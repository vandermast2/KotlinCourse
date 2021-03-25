package com.samapps.kotlincourse.extentions

import android.content.Context
import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.View
import android.widget.Toast


fun View.onClick(body: () -> Unit) {
    this.setOnClickListener { body() }
}

fun Context.toast(message:String) = Toast.makeText(this,message,Toast.LENGTH_SHORT).show()


val String.Companion.EMPTY: String
    get() = ""

fun String.nullIfEmpty() = ifEmpty { null }

fun CharSequence.spannableBold(
        startIndex: Int = 0,
        textLength: Int
): SpannableStringBuilder = SpannableStringBuilder(this).apply {
    setSpan(
            StyleSpan(Typeface.BOLD),
            startIndex,
            startIndex + textLength,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
    )
}