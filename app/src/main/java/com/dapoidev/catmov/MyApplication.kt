package com.dapoidev.catmov

import android.app.Application
import com.dapoidev.catmov.core.di.databaseModule
import com.dapoidev.catmov.core.di.networkModule
import com.dapoidev.catmov.core.di.repositoryModule
import com.dapoidev.catmov.di.useCaseModule
import com.dapoidev.catmov.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}