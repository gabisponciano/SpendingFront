package com.gabrielaponciano.spendingapp.model

import kotlinx.serialization.Serializable
import java.time.LocalDateTime
@Serializable
data class Spending(
    val id: Int = 0,
    val day: Long,
    val value: Float,
    val userId: Int
)