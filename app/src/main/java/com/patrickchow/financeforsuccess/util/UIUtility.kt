package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class UIUtility {
    companion object {

        @Composable
        fun SmallSpacer() {
            Spacer(modifier = Modifier.height(8.dp))
        }

        @Composable
        fun MediumSpacer() {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
