package com.gabrielaponciano.spendingapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Spending(
    val id: Int = 0,
    val name: String,
    val day: Long,
    val value: Float,
    val userId: Int
)