package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplanationBottomSheet(
    message: String,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        scrimColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f) // Adjust the alpha value for shadow effect
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = message)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onDismiss() }) {
                Text("Close")
            }
        }
    }
}
