package com.gabrielaponciano.spendingapp.ui.theme.States

import androidx.compose.material3.DatePickerState

data class AddExpenseUiState(
    val name: String = "",
    val date: Long? = null,
    val value: Float? = null,
    val nameInput:String = "",
    val dateInput: Long? = null,
    val valueInput: Float? = null,

)