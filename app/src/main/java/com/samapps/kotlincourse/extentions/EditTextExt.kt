package com.samapps.kotlincourse.extentions

import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow


fun EditText.focusAndPlaceCursorEnd() {
    requestFocus()
    setSelection(length())
}

fun EditText.setTextWithSelection(text: String) {
    setText(text)
    setSelection(text.length)
}

fun EditText.placeCursorToEnd() {
    setSelection(text.length)
}

@ExperimentalCoroutinesApi
fun EditText.textInputAsFlow() = callbackFlow {
    val watcher: TextWatcher = doAfterTextChanged {
        offer(it.toString())
    }
    awaitClose { this@textInputAsFlow.removeTextChangedListener(watcher) }
}