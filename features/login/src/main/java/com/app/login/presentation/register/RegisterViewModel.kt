package com.app.login.presentation.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.login.domain.register.RegisterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {


    fun setRegisterClick(text: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        registerUseCase(text, password).collect{
//            val result = it
//            Log.d("TAG_FIREBASE", it.toString())
//            it.user
//            Log.d("TAG_FIREBASE",it.user.toString())
//            it.credential
//            Log.d("TAG_FIREBASE",it.credential.toString())

        }
    }
}