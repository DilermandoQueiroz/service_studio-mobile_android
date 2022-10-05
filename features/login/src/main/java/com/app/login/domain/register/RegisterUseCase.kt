package com.app.login.domain.register

import com.app.login.data.FirebaseRepository
import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import kotlinx.coroutines.flow.Flow

class RegisterUseCase(private val firebaseRepository: FirebaseRepository) {
    operator fun invoke(user: UserModel, password: String) : Flow<LoginResult> {
        return firebaseRepository.authLogin(user, password)
    }
}