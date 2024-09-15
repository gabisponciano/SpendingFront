package com.gabrielaponciano.spendingapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("")
    .build()

object ExpenseControllerApi{
    val retrofitService : RoutesApiService by lazy {
        retrofit.create(RoutesApiService::class.java)
    }
}