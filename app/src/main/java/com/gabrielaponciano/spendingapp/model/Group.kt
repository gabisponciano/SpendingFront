package com.gabrielaponciano.spendingapp.model

import com.google.firebase.firestore.auth.User
import kotlinx.serialization.Serializable

@Serializable
data class Group(
    val id: Int = 0,
    val name: String,
    val password: String,
    //val users: List<User> = emptyList()
)