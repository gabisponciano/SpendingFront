package com.gabrielaponciano.spendingapp.model

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteRequest(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val spendings: List<Spending> = emptyList(),
    val groupId: Int? = null

)