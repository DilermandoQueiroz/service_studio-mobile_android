package com.app.demo

import android.app.Application
import com.app.login.domain.register.RegisterUseCase
import com.app.login.presentation.register.RegisterViewModel
import com.app.navigation.NavigatorAppTattoo
import com.app.navigation.NavigatorImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class TattooAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TattooAppApplication)
            modules(listOf(loginModule, navigationModule))
        }
    }
    private val navigationModule = module {
        single <NavigatorAppTattoo>{ NavigatorImpl() }
    }
    private val loginModule = module {
        viewModel { RegisterViewModel(registerUseCase = RegisterUseCase()) }
    }
}