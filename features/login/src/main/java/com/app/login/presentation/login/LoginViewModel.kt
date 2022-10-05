package com.app.login.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.firebaseapp.domain.LoginResult
import com.app.login.domain.login.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel(
    private val registerUseCase: LoginUseCase
) : ViewModel() {

    private val _loginResult = MutableSharedFlow<LoginResult>(0)
    val loginResult = _loginResult.asSharedFlow()

    fun logging(email: String, password: String) =
            viewModelScope.launch(Dispatchers.IO) {
                registerUseCase(email, password)
                    .onStart { _loginResult.emit(LoginResult.Loading(true)) }
                    .catch { _loginResult.emit(LoginResult.Error(it.message.orEmpty())) }
                    .onCompletion { _loginResult.emit(LoginResult.Loading(false)) }
                    .collect { _loginResult.emit(it) }
            }
}