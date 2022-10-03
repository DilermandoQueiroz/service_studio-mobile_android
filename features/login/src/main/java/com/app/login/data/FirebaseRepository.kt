package com.app.login.data

import com.app.firebaseapp.LoginResult
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {
    fun authLogin(text: String, password: String): Flow<LoginResult>
}