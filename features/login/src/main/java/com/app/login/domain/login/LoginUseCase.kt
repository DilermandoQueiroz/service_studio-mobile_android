package com.app.login.domain.login

import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import com.app.login.data.FirebaseRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(private val firebaseRepository: FirebaseRepository) {
    operator fun invoke(user: UserModel, password: String) : Flow<LoginResult> {
        return firebaseRepository.createUserWithEmailAndPassword(user, password)
    }
}