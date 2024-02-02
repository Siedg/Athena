package br.com.athena.core.extensions

// Regex Patterns
const val CPF_MASKED = "(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})"
const val ZIPCODE_MASKED = "(\\d{5})-(\\d{3})"
const val CNPJ_MASKED = "(\\d{2})[.](\\d{3})[.](\\d{3})/(\\d{4})-(\\d{2})"
const val CURRENCY_MASKED = "\\d{1,3}(\\.\\d{3})*(,\\d{2})?"
const val PHONE_MASKED = "\\((\\d{2})\\)\\s(\\d{5})-(\\d{4})"
const val DATE_MASKED = "(\\d{2})(/\\d{2})(/\\d{4})"
const val ONLY_NUMBERS = "[0-9]*"
const val FULL_NAME = "(\\w.+\\s)[a-zA-Zà-ú][^0-9]{2,}+"

// Masks
const val CPF_MASK = "###.###.###-##"
const val CEP_MASK = "#####-###"
const val CNPJ_MASK = "##.###.###/####-##"
const val PHONE_MASK = "(##) #####-####"
const val DATE_MASK = "##/##/####"