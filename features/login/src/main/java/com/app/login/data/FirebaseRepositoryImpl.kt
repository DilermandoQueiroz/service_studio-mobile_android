package com.app.login.data

import com.app.firebaseapp.FirebaseApp
import com.app.firebaseapp.LoginResult
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn

class FirebaseRepositoryImpl(
) : FirebaseRepository {
    override fun authLogin(text: String, password: String): Flow<LoginResult> {
        val result = FirebaseApp.authLogin(text, password)
        return result
    }
}