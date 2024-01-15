package br.com.athena.signin.di

import br.com.athena.signin.data.SignInWithEmail
import br.com.athena.signin.data.SignInWithEmailImpl
import br.com.athena.signin.data.SignInWithGoogleAuthUIClient
import br.com.athena.signin.data.SignInWithGoogleAuthUIClientImpl
import br.com.athena.signin.presentation.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val AthenaLoginModule = module {
    single { FirebaseAuth.getInstance() }
//    singleOf(::FirebaseAuth)
    singleOf(::SignInWithEmailImpl) { bind<SignInWithEmail>() }
    singleOf(::SignInWithGoogleAuthUIClientImpl) { bind<SignInWithGoogleAuthUIClient>() }
    viewModelOf(::LoginViewModel)
}