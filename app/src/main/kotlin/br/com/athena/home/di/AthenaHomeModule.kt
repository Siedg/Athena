package br.com.athena.home.di

import br.com.athena.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AthenaHomeModule = module {

    viewModel { HomeViewModel() }
    //viewModelOf(::HomeViewModel)
}