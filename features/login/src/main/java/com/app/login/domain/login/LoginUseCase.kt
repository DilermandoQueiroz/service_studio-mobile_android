package com.app.login.domain.login

import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import com.app.login.data.FirebaseRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(private val firebaseRepository: FirebaseRepository) {
    operator fun invoke(email: String, password: String) : Flow<LoginResult> {
        return firebaseRepository.loginUserWithEmailAndPassword(email, password)
    }
}