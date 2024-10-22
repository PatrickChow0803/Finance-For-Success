package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.ui.extensions.customScrollableColumn

@Composable
fun AppScaffold(
    title: String,
    navController: NavController,
    content: @Composable ColumnScope.(PaddingValues) -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CustomAppBar(
                title = title,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .customScrollableColumn(scrollState, innerPadding),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            content(innerPadding) // Pass the padding to the content inside the column
        }
    }
}

