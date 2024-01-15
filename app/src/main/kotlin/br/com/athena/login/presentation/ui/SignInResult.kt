package br.com.athena.login.presentation.ui

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String = "",
    val username: String? = "",
    val profilePictureUrl: String? = "",
    val email: String? = "",
    val phoneNumber: String? = ""
)
