package com.app.navigation

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class NavigationApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NavigationApplication)
            modules(navigationModule)
        }
    }
    private val navigationModule = module {
        single <NavigatorAppTattoo>{ NavigatorImpl() }
    }
}