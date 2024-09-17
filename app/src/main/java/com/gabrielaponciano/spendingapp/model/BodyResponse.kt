package com.gabrielaponciano.spendingapp.model

data class BodyResponse<T>(
    val message: String,
    val data: T
)
