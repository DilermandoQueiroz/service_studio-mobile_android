package com.app.login.presentation.register

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.firebaseapp.LoginResult
import com.app.login.domain.register.RegisterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {


    fun setRegisterClick(text: String, password: String, context: Context) = viewModelScope.launch(Dispatchers.IO) {
        registerUseCase(text, password).collect {
            if (it == LoginResult.SUCESS) {
                Log.d("TAG_FIREBASE", "Success")
            } else {
                Log.d("TAG_FIREBASE", "Error")
            }

        }
    }
}