package com.app.navigation

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class NavigationApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        org.koin.core.context.startKoin {
            androidLogger()
            androidContext(this@NavigationApplication)
            modules(listOf(navigationModule))
        }
    }
    private val navigationModule = module {
        single <NavigatorAppTattoo>{ NavigatorImpl() }
    }

}