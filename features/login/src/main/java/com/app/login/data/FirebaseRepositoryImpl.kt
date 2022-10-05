package com.app.login.data

import com.app.firebaseapp.FirebaseApp
import com.app.commons.domain.UserModel
import com.app.firebaseapp.domain.LoginResult
import kotlinx.coroutines.flow.Flow

class FirebaseRepositoryImpl(
) : FirebaseRepository {
    override fun authLogin(user: UserModel, password: String): Flow<LoginResult> {
        val result = FirebaseApp.authLogin(user, password)
        return result
    }
}