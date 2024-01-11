package br.com.athena.components.texts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ErrorTextFieldState(
    initialText: String,
    private val validator: (String) -> String?,
) {
    var text by mutableStateOf(initialText)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    val isValid: Boolean
        get() = error.isNullOrBlank() && text.isNotEmpty()

    fun updateText(newValue: String) {
        text = newValue
        error = null
    }

    fun validate() {
        error = validator(text)
    }

    companion object {
        fun Saver(
            validate: (String) -> String?,
        ) = androidx.compose.runtime.saveable.Saver<ErrorTextFieldState, String>(
            save = { it.text },
            restore = { ErrorTextFieldState(it, validate) }
        )
    }
}
