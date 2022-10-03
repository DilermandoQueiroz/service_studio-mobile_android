package com.app.login.domain.register

import com.app.firebaseapp.LoginResult
import com.app.login.data.FirebaseRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class RegisterUseCase(private val firebaseRepository: FirebaseRepository) {
    operator fun invoke(text: String, password: String) : Flow<LoginResult> {
        return firebaseRepository.authLogin(text, password)
    }
}