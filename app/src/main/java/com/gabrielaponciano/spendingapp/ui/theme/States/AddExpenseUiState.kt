package com.gabrielaponciano.spendingapp.ui.theme.States

data class AddExpenseUiState(
    val name: String = "",
    val date: Long? = null,
    val value: Float? = null
)