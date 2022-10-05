package com.app.firebaseapp.domain

sealed class LoginResult {
    data class Error(val message: String) : LoginResult()
    object Success : LoginResult()
}