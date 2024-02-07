package br.com.athena.register.di

import br.com.athena.register.data.RegisterWithEmail
import br.com.athena.register.data.RegisterWithEmailImpl
import com.google.firebase.auth.FirebaseAuth
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val AthenaRegisterModule = module {
    single { FirebaseAuth.getInstance() }
    singleOf(::RegisterWithEmailImpl) { bind<RegisterWithEmail>() }
}