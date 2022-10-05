package com.app.demo.presentation

import android.app.Application
import com.app.demo.presentation.navigation.AppNavigationImpl
import com.app.firebaseapp.FirebaseApp
import com.app.home.navigation.HomeNavigationImpl
import com.app.login.data.FirebaseRepository
import com.app.login.data.FirebaseRepositoryImpl
import com.app.login.domain.login.LoginUseCase
import com.app.login.domain.register.RegisterUseCase
import com.app.login.navigation.LoginNavigatorImpl
import com.app.login.presentation.login.LoginViewModel
import com.app.login.presentation.register.RegisterViewModel
import com.app.navigation.AppNavigator
import com.app.navigation.HomeNavigator
import com.app.navigation.LoginNavigator
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
        single<AppNavigator> { AppNavigationImpl() }
        single<LoginNavigator> { LoginNavigatorImpl() }
        single<HomeNavigator> { HomeNavigationImpl() }
    }
    private val loginModule = module {
        single<FirebaseRepository> { FirebaseRepositoryImpl() }
        viewModel { RegisterViewModel(registerUseCase = RegisterUseCase(firebaseRepository = get())) }
        viewModel { LoginViewModel(registerUseCase = LoginUseCase(firebaseRepository = get())) }
    }
}