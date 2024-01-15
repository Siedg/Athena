package br.com.athena.hawk

import br.com.athena.login.presentation.ui.UserData
import com.orhanobut.hawk.Hawk

object HawkSession {
    fun getUserData(): UserData = Hawk.get(USER_DATA, UserData())

    fun saveUserData(userData: UserData) = Hawk.put(USER_DATA, userData)

    fun isUserLoggedIn(): Boolean = Hawk.contains(USER_DATA)

    fun onUserSignOut(): Boolean = Hawk.delete(USER_DATA)
}