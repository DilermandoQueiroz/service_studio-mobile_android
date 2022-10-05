package com.app.login.domain.register

sealed class RegisterResult {
    data class Error(val message: String) : RegisterResult()
    object Success : RegisterResult()
    data class Loading(val isLoading: Boolean) : RegisterResult()
}