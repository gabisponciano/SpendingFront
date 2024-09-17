package com.gabrielaponciano.spendingapp.model

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val userId: Int,
    val token: String
)
