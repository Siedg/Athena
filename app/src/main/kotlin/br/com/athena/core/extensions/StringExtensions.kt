package br.com.athena.core.extensions

fun String.validate(type: DataType): Boolean {
    return !this.isNullOrEmpty() && when(type) {
        DataType.CPF -> this.matches(CPF_MASKED.toRegex())
        DataType.ZIPCODE -> this.matches(ZIPCODE_MASKED.toRegex())
        DataType.CNPJ -> this.matches(CNPJ_MASKED.toRegex())
        DataType.CURRENCY -> this.matches(CURRENCY_MASKED.toRegex())
        DataType.PHONE -> this.matches(PHONE_MASKED.toRegex())
        DataType.DATE -> this.matches(DATE_MASKED.toRegex())
        DataType.FULL_NAME -> this.matches(FULL_NAME.toRegex())
        else -> false
    }
}

fun String.mask(mask: String): String {
    val masked: StringBuilder = StringBuilder()
    var unmasked = this.unmask()
    if (!mask.isNullOrEmpty() && mask.contains("#".toRegex()) && this.length <= mask.length) {
        for (i in mask.indices) {
            if (unmasked.isEmpty()) break
            else if (mask[i] != '#') {
                masked.append(mask[i])
            } else {
                masked.append(unmasked[0])
                unmasked = unmasked.pop()
            }
        }
    }
    return masked.toString()
}

fun String.unmask(): String {
    if (this.isNullOrEmpty()) {
        return ""
    }
    return this.filter { it.isLetterOrDigit() }
}

fun String.pop(): String = this.substring(1)

fun String.calculateCPF(): Boolean {
    if (this.isEmpty()) return false
    val numbers = this.filter { it.isDigit() }.map {
        it.toString().toInt()
    }
    if (numbers.size != 11) return false
    if (numbers.all { it == numbers[0] }) return false
    val dv1 = ((0..8).sumOf { (it + 1) * numbers[it] }).rem(11).let {
        if (it >= 10) 0 else it
    }
    val dv2 = ((0..8).sumOf { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
        if (it >= 10) 0 else it
    }
    return numbers[9] == dv1 && numbers[10] == dv2
}