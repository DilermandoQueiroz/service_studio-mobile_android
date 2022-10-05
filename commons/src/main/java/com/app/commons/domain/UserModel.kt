package com.app.commons.domain

data class UserModel(
    val name: String,
    val email: String,
    val image: String = ""
)