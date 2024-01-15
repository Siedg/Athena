package br.com.athena.signin.presentation.ui

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
