package br.com.athena.login.di

import br.com.athena.login.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AthenaLoginModule = module {
    viewModel { LoginViewModel() }
}