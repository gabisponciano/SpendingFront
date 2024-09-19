package com.gabrielaponciano.spendingapp.network

import com.gabrielaponciano.spendingapp.model.BodyResponse
import com.gabrielaponciano.spendingapp.model.Group
import com.gabrielaponciano.spendingapp.model.GroupCreate
import com.gabrielaponciano.spendingapp.model.GroupJoin
import com.gabrielaponciano.spendingapp.model.GroupLeave
import com.gabrielaponciano.spendingapp.model.LoginRequest
import com.gabrielaponciano.spendingapp.model.LoginResponse
import com.gabrielaponciano.spendingapp.model.Spending
import com.gabrielaponciano.spendingapp.model.User
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

object Constants {
    const val BACKEND_URL = "http://196.168.0.10:3000"
}

object ExpenseControllerApi{
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://196.168.0.10:3000")
        .build()

    private val request = retrofit.create(RoutesApiService::class.java)

    fun getHeaderRequest(token: String) : Map<String, String> {
        return mapOf("Authorization" to "Bearer ${token}")
    }

    // USER
    suspend fun createUser(user: User) : BodyResponse<User> {
        return request.createUser(user).await()
    }

    suspend fun loginUser(logiRequest: LoginRequest) : BodyResponse<LoginResponse> {
        return request.loginUser(logiRequest).await()
    }

    // SPENDING
    suspend fun getSpendingsByUserId(userId: Int, token: String) : BodyResponse<List<Spending>> {
        return request.getSpendingsByUserId(userId, getHeaderRequest(token)).await()
    }

    suspend fun createSpendingUser(spending: Spending, token: String) : BodyResponse<Map<String, String>> {
        return request.createSpendingUser(spending, getHeaderRequest(token)).await()
    }

    suspend fun updateSpendingUser(userId: Int, spending: Spending, token: String) : BodyResponse<Map<String, String>>? {
        return request.updateSpendingUser(userId, spending, getHeaderRequest(token)).await()
    }

    suspend fun deleteSpendingUser(spendingId: Int, token: String) : BodyResponse<Map<String, String>> {
        return request.deleteSpendingUser(spendingId, getHeaderRequest(token)).await()
    }

    // GROUP
    suspend fun getAllGroups(token: String): BodyResponse<List<Group>> {
        return request.getAllGroups(getHeaderRequest(token)).await()
    }

    suspend fun getGroupById(groupId: Int, token: String): BodyResponse<Group> {
        return request.getGroupById(groupId, getHeaderRequest(token)).await()
    }

    suspend fun createGroup(groupCreate: GroupCreate, token: String): BodyResponse<Map<String, String>> {
        return request.createGroup(groupCreate, getHeaderRequest(token)).await()
    }

    suspend fun joinGroup(groupjoin: GroupJoin, token: String): BodyResponse<Map<String, String>> {
        return request.joinGroup(groupjoin, getHeaderRequest(token)).await()
    }

    suspend fun leaveGroup(groupLeave: GroupLeave, token: String): BodyResponse<Map<String, String>> {
        return request.leaveGroup(groupLeave, getHeaderRequest(token)).await()
    }
}