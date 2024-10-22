package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.patrickchow.financeforsuccess.dataclass.ModalSheetInformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplanationBottomSheet(
    modalSheetInfo: ModalSheetInformation,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        scrimColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f) // Shadow effect
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Display title
            Text(
                text = modalSheetInfo.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Display description
            Text(
                text = modalSheetInfo.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { onDismiss() }) {
                Text("Close")
            }
        }
    }
}
