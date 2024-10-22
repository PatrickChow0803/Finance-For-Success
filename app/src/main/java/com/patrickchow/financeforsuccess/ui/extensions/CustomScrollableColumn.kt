package com.patrickchow.financeforsuccess.ui.extensions

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.customScrollableColumn(scrollState: ScrollState, innerPadding: PaddingValues): Modifier {
    return this
        .fillMaxSize()
        .padding(innerPadding)
        .padding(16.dp)
        .verticalScroll(scrollState)
}
