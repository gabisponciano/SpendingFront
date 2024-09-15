package com.gabrielaponciano.spendingapp.ui.theme.UI.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.spendingapp.R
import com.gabrielaponciano.spendingapp.ui.theme.Components.AddButton
import com.gabrielaponciano.spendingapp.ui.theme.Components.CardItem
import com.gabrielaponciano.spendingapp.ui.theme.States.AddExpenseUiState
import com.gabrielaponciano.spendingapp.ui.theme.ViewModels.AddExpenseViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(navController: NavController) {
    val addExpenseViewModel = viewModel<AddExpenseViewModel>()
    val expenses by addExpenseViewModel.expenses.collectAsState()

    Scaffold (
        bottomBar = {
            AddButton(){
                navController.navigate("add")
            }
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Box {
                Image(
                    painter = painterResource(R.drawable.ic_topbar),
                    contentDescription = ""
                )
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Hello, User",
                        fontSize = 32.sp,
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )

                    CardItem(
                        modifier = Modifier.padding(top = 16.dp),
                        balance = "$2560.00",
                        expense = "$1535"
                    )
                }
            }
            Text(
                text = "Expenses",
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(expenses) { expense ->
                    ExpenseItem(expense)
                }
            }
        }
    }
}
@Composable
fun ExpenseItem(expense: AddExpenseUiState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = expense.name, fontSize = 18.sp)
            Text(text = "Amount: ${expense.value}", fontSize = 14.sp)
            expense.date?.let {
                Text(text = "Date: ${SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it))}", fontSize = 14.sp)
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}