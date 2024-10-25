package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.ui.extensions.customScrollableColumn

/**
 *  The standard scaffold for each screen. Comes with the appbar and a scroller
 *  */
@Composable
fun AppScaffold(
    title: String,
    navController: NavController,
    useScrollableColumn: Boolean = true,
    content: @Composable (PaddingValues) -> Unit // Change to accept PaddingValues directly
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
        if (useScrollableColumn) {
            Column(
                modifier = Modifier
                    .customScrollableColumn(scrollState, innerPadding),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                content(innerPadding)
            }
        } else {
            // If not using a scrollable column, use a regular layout
            Box(modifier = Modifier.padding(innerPadding)) {
                content(innerPadding)
            }
        }
    }
}


