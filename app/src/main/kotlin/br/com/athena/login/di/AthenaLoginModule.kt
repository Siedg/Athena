package br.com.athena.login.di

import br.com.athena.login.data.SignInWithEmail
import br.com.athena.login.data.SignInWithEmailImpl
import br.com.athena.login.data.SignInWithGoogleAuthUIClient
import br.com.athena.login.data.SignInWithGoogleAuthUIClientImpl
import br.com.athena.login.presentation.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val AthenaLoginModule = module {
    single { FirebaseAuth.getInstance() }
    singleOf(::SignInWithEmailImpl) { bind<SignInWithEmail>() }
    singleOf(::SignInWithGoogleAuthUIClientImpl) { bind<SignInWithGoogleAuthUIClient>() }
    viewModelOf(::LoginViewModel)
}