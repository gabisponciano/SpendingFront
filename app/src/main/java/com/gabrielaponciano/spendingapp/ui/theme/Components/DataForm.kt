package com.gabrielaponciano.spendingapp.ui.theme.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gabrielaponciano.spendingapp.ui.theme.ViewModels.AddExpenseViewModel

@Composable
fun DataForm(modifier: Modifier, ) {
    val addExpenseViewModel = viewModel<AddExpenseViewModel>()
    //val uiState by AddExpenseViewModel.uiState.collectAsState()
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(text = "Name", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Amount", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Date", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = { /* TODO */ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Add Expense")
        }
    }
}