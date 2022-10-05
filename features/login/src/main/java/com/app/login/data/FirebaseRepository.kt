package com.app.login.data

import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {
    fun authLogin(user: UserModel, password: String): Flow<LoginResult>
}