package com.app.login.presentation.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import com.app.login.domain.register.RegisterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {



    fun setRegisterClick(user: UserModel, password: String) = viewModelScope.launch(Dispatchers.IO) {
        registerUseCase(user, password).collect {
            if (it == LoginResult.Success) {
                Log.d("TAG_FIREBASE", "Success")
            } else {
                Log.d("TAG_FIREBASE", "Error")
            }
        }
    }
}