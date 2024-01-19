package br.com.athena.core.extensions

fun String.validate(type: DataType): Boolean {
    return !this.isNullOrEmpty() && when(type) {
        DataType.ZIPCODE -> this.matches(ZIPCODE_FORMATTED.toRegex())
        else -> false
    }
}