package com.app.login.presentation.login

import androidx.lifecycle.ViewModel
import com.app.login.domain.login.LoginUseCase

class LoginViewModel(
    private val registerUseCase: LoginUseCase
) : ViewModel() {
}