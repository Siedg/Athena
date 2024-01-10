package br.com.athena.sample

import android.app.Application
import br.com.athena.home.di.AthenaHomeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AthenaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AthenaApplication)
            modules(
                AthenaHomeModule
            )
        }
    }
}