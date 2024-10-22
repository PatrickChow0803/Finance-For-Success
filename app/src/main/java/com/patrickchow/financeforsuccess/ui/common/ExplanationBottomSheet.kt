package com.patrickchow.financeforsuccess.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = modalSheetInfo.title,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = modalSheetInfo.description,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 20.sp,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onDismiss() },
                modifier = Modifier.fillMaxWidth() // Stretch the button
            ) {
                Text("Close")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
