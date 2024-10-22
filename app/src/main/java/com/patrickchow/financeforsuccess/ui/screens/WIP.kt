package com.patrickchow.financeforsuccess.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.patrickchow.financeforsuccess.R
import com.patrickchow.financeforsuccess.dataclass.CalculatorItem
import com.patrickchow.financeforsuccess.ui.common.CustomAppBar

@Composable
fun WIP(calculatorItem: CalculatorItem, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomAppBar(
            title = calculatorItem.title,
            onBackClick = { navController.popBackStack() }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${calculatorItem.title} ${stringResource(id = R.string.wip_description)}",
                fontSize = 20.sp,
                color = Color.Gray
            )
        }
    }
}