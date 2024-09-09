package com.gabrielaponciano.spendingapp.ui.theme.UI.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.spendingapp.R
import com.gabrielaponciano.spendingapp.ui.theme.Components.CardItem

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold { paddingValues ->
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
                        text = "Olá, User",
                        fontSize = 32.sp,
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )

                    CardItem(
                        modifier = Modifier.padding(top = 16.dp),
                        balance = "$256.00",
                        income = "$1500",
                        expense = "$1535"
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}