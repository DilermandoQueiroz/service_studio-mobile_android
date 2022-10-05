package com.app.firebaseapp.domain

sealed class LoginResult {
    data class Error(val message: String) : LoginResult()
    data class Loading(val isLoading: Boolean) : LoginResult()
    object Success : LoginResult()
}