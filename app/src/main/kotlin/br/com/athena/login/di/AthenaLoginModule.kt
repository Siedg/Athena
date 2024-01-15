package br.com.athena.login.di

import br.com.athena.login.data.GoogleAuthUIClient
import br.com.athena.login.data.GoogleAuthUIClientImpl
import br.com.athena.login.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val AthenaLoginModule = module {
    singleOf(::GoogleAuthUIClientImpl) { bind<GoogleAuthUIClient>() }
    viewModelOf(::LoginViewModel)
}