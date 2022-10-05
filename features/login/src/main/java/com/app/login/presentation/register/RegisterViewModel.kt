package com.app.login.presentation.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import com.app.login.domain.register.RegisterResult
import com.app.login.domain.register.RegisterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {


    private val _loginResult = MutableSharedFlow<RegisterResult>(0)
    val loginResult = _loginResult.asSharedFlow()

    fun setRegisterClick(user: UserModel, password: String) =
        viewModelScope.launch(Dispatchers.IO) {
            registerUseCase(user, password)
                .onStart { _loginResult.emit(RegisterResult.Loading(true)) }
                .catch { _loginResult.emit(RegisterResult.Error(it.message.orEmpty())) }
                .onCompletion { _loginResult.emit(RegisterResult.Loading(false)) }
                .collect { _loginResult.emit(RegisterResult.Success) }
        }
}