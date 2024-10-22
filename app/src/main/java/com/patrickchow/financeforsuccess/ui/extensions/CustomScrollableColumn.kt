package com.patrickchow.financeforsuccess.ui.extensions

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState

fun Modifier.customScrollableColumn(scrollState: ScrollState, innerPadding: PaddingValues): Modifier {
    return this
        .fillMaxSize()
        .padding(innerPadding)
        .padding(16.dp)
        .verticalScroll(scrollState)
}
