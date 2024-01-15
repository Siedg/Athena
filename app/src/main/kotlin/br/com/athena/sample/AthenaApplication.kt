package br.com.athena.sample

import android.app.Application
import br.com.athena.home.di.AthenaHomeModule
import br.com.athena.login.di.AthenaLoginModule
import com.orhanobut.hawk.Hawk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AthenaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupHawk()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AthenaApplication)
            modules(
                AthenaHomeModule,
                AthenaLoginModule
            )
        }
    }

    private fun setupHawk() {
        Hawk.init(this).build()
    }
}