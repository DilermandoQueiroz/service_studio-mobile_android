package com.app.login.data

import com.app.firebaseapp.FirebaseApp
import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import kotlinx.coroutines.flow.Flow

class FirebaseRepositoryImpl(
) : FirebaseRepository {
    override fun createUserWithEmailAndPassword(user: UserModel, password: String): Flow<LoginResult> {
        val result = FirebaseApp.createUserWithEmailAndPassword(user, password)
        return result
    }

    override fun loginUserWithEmailAndPassword(email: String, password: String): Flow<LoginResult> {
        val result = FirebaseApp.loginUserWithEmailAndPassword(email, password)
        return result
    }
}