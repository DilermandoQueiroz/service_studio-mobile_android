package com.app.login.presentation.register

import androidx.lifecycle.ViewModel
import com.app.login.domain.register.RegisterUseCase

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    fun setRegisterClick(){
        registerUseCase
    }
}