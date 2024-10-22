package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AppScaffold(
    title: String,
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            CustomAppBar(
                title = title,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}
