package com.app.login.data

import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {
    fun createUserWithEmailAndPassword(user: UserModel, password: String): Flow<LoginResult>
    fun loginUserWithEmailAndPassword(email: String, password: String): Flow<LoginResult>
}